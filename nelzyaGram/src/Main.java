import model.*;
import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Я запустилась!");
        System.out.println("Рабочая папка: " + System.getProperty("user.dir"));

        File testConfig = new File("config");
        System.out.println("config существует? " + testConfig.exists());
        System.out.println("config полный путь: " + testConfig.getAbsolutePath());

        if (!testConfig.exists()) {
            System.err.println("СОЗДАЙ ПАПКУ config ПО ЭТОМУ ПУТИ: " + testConfig.getAbsolutePath());
            return;
        }

        // 2. Читаем конфиг
        ConfigReader configReader = new ConfigReader("config/settings.cfg");
        AppConfig config = configReader.read();
        System.out.println("Привет, " + config.username + "!");

        // 3. Рисуем аватар
        File avatarFile = new File("config/avatar.txt");
        if (!avatarFile.exists()) {
            System.err.println("Ошибка: config/avatar.txt не найден!");
            return;
        }
        AvatarRenderer avatar = new AvatarRenderer("config/avatar.txt");
        avatar.render();

        // 4. Загружаем старые посты для подсчёта общего количества
        int totalPostsEver = 0;
        File postsFile = new File("data/posts.dat");
        if (postsFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(postsFile))) {
                List<Post> oldPosts = (List<Post>) ois.readObject();
                totalPostsEver = oldPosts.size();
            } catch (Exception e) {
                System.out.println("Не удалось загрузить старые посты: " + e.getMessage());
            }
        }

        // 5. Считаем количество запусков
        int launchCount = 1;
        File launchFile = new File("data/launch_count.dat");
        if (launchFile.exists()) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(launchFile))) {
                launchCount = dis.readInt() + 1;
            } catch (Exception e) {}
        }
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(launchFile))) {
            dos.writeInt(launchCount);
        }

        // 6. Создаём менеджер достижений
        AchievementManager achManager = new AchievementManager(launchCount);

        // 7. Запускаем потоки для постов
        PipedOutputStream pipeOut = new PipedOutputStream();
        PipedInputStream pipeIn = new PipedInputStream(pipeOut);

        PostWriter writer = new PostWriter(config, pipeOut);
        PostSaver saver = new PostSaver(pipeIn);

        Thread writerThread = new Thread(writer);
        Thread saverThread = new Thread(saver);

        writerThread.start();
        saverThread.start();

        // 8. Запускаем поток снапшотов (демон)
        SnapshotThread snapshotThread = new SnapshotThread(config.username, config.bio);
        snapshotThread.start();

        // 9. Ждём завершения ввода постов
        writerThread.join();

        // Останавливаем снапшоты
        snapshotThread.stopThread();

        // Ждём сохранения всех постов
        saverThread.join();

        // 10. Получаем посты этой сессии
        List<Post> sessionPosts = saver.getAllPosts();
        snapshotThread.updatePostsCount(sessionPosts.size());

        // 11. Проверяем достижения
        for (int i = 0; i < sessionPosts.size(); i++) {
            Post p = sessionPosts.get(i);
            totalPostsEver++;
            achManager.check(p, i + 1, totalPostsEver);

            // Проверка на быстрые пальцы
            if (i > 0) {
                long diff = p.timestamp - sessionPosts.get(i - 1).timestamp;
                achManager.checkFastFingers(diff, false);
            }
        }

        // Проверка на "Пять из пяти"
        if (sessionPosts.size() == config.maxPosts) {
            achManager.checkFiveOfFive(sessionPosts.size(), config.maxPosts, false);
        }

        // 12. Анализируем ленту
        FeedAggregator feedAgg = new FeedAggregator("config/feed_part1.txt", "config/feed_part2.txt");
        Thread feedThread = new Thread(feedAgg);
        feedThread.start();
        feedThread.join();

        // 13. Сохраняем достижения
        achManager.saveAchievements();

        // 14. Формируем итоговый отчёт
        try (PrintWriter report = new PrintWriter(new FileWriter("reports/summary.txt"))) {
            report.println(config.username);
            report.println("   " + config.bio);
            report.println();

            report.println("Посты этой сессии:");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for (int i = 0; i < sessionPosts.size(); i++) {
                Post p = sessionPosts.get(i);
                String time = LocalDateTime.ofInstant(Instant.ofEpochMilli(p.timestamp), ZoneId.systemDefault()).format(formatter);
                report.println("   #" + (i + 1) + "  [" + time + "]  " + p.text);
            }

            report.println();
            report.println("Достижения (всего: " + achManager.getAchievements().size() + "):");
            for (Achievement a : achManager.getAchievements()) {
                report.println("   " + a.title);
            }

            report.println();
            report.println("Лента:");
            report.println("   Всего постов: " + feedAgg.totalPosts);
            report.println("   Суммарно лайков: " + feedAgg.totalLikes);
            report.println("   Топ автор: " + feedAgg.topAuthor + " (" + feedAgg.topLikes + " лайков)");
            report.println();
            report.println("   === Активность ===");
            for (String line : feedAgg.top5Activity) {
                report.println("   " + line);
            }

            report.println();
            File avatarFileForReport = new File("config/avatar.txt");
            report.println("Аватар: сохранён бэкап (" + avatarFileForReport.length() + " байт)");

            // Последний снапшот
            File snapDir = new File("data/snapshots");
            File[] snaps = snapDir.listFiles((dir, name) -> name.startsWith("profile_") && name.endsWith(".ser"));
            if (snaps != null && snaps.length > 0) {
                Arrays.sort(snaps, (a, b) -> Long.compare(b.lastModified(), a.lastModified()));
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(snaps[0]))) {
                    UserProfile lastProfile = (UserProfile) ois.readObject();
                    String lastTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastProfile.lastActiveTimestamp), ZoneId.systemDefault()).format(formatter);
                    report.println();
                    report.println("Последний снапшот профиля:");
                    report.println("   Постов за всё время: " + lastProfile.postsWritten);
                    report.println("   Статус: \"" + lastProfile.status + "\"");
                    report.println("   Время: " + lastTime);
                }
            }
        }

        System.out.println("\nОтчёт сохранён в reports/summary.txt");
    }
}