import model.Achievement;
import model.Post;
import java.io.*;
import java.util.*;

public class AchievementManager {
    private List<Achievement> achievements;
    private int launchCount;
    private Set<String> unlockedTitles;

    public AchievementManager(int launchCount) {
        this.launchCount = launchCount;
        this.unlockedTitles = new HashSet<>();
        this.achievements = new ArrayList<>();
        loadAchievements();
    }

    @SuppressWarnings("unchecked")
    private void loadAchievements() {
        File file = new File("data/achievements.ser");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                achievements = (List<Achievement>) ois.readObject();
                for (Achievement a : achievements) {
                    unlockedTitles.add(a.title);
                }
                System.out.println("Загружено " + achievements.size() + " старых достижений");
            } catch (IOException | ClassNotFoundException e) {
                achievements = new ArrayList<>();
            }
        } else {
            achievements = new ArrayList<>();
        }
    }

    public void check(Post post, int totalPostsThisSession, int totalPostsEver) {
        if (totalPostsEver == 1 && !unlockedTitles.contains("Первый пост")) {
            unlock("🏆", "Первый пост", "Написан первый пост за всё время");
        }

        if (post.text.length() > 100 && !unlockedTitles.contains("Многословный")) {
            unlock("📖", "Многословный", "Пост длиннее 100 символов");
        }

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(post.timestamp);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if ((hour >= 23 || hour < 4) && !unlockedTitles.contains("Ночной кодер")) {
            unlock("🌙", "Ночной кодер", "Пост написан с 23:00 до 4:00");
        }

        // Старожил
        if (launchCount >= 3 && !unlockedTitles.contains("Старожил")) {
            unlock("👴", "Старожил", "Программа запущена 3 и более раз");
        }
    }

    public void checkFastFingers(long timeDiff, boolean already) {
        if (timeDiff < 5000 && !already && !unlockedTitles.contains("Быстрые пальцы")) {
            unlock("⚡", "Быстрые пальцы", "Два поста подряд с паузой менее 5 секунд");
        }
    }

    public void checkFiveOfFive(int written, int maxPosts, boolean already) {
        if (written == maxPosts && !already && !unlockedTitles.contains("Пять из пяти")) {
            unlock("🎯", "Пять из пяти", "За одну сессию написано maxPosts постов без exit");
        }
    }

    private void unlock(String emoji, String title, String desc) {
        Achievement a = new Achievement(emoji, title, desc, System.currentTimeMillis());
        achievements.add(a);
        unlockedTitles.add(title);
        System.out.println("УРА: " + emoji + " " + title + "! (" + desc + ")");
    }

    public void saveAchievements() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/achievements.ser"))) {
            oos.writeObject(achievements);
            System.out.println("Достижения сохранены");
        } catch (IOException e) {
            System.err.println("Не удалось сохранить достижения: " + e);
        }
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}