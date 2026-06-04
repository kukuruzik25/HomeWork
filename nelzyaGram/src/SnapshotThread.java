import model.UserProfile;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SnapshotThread extends Thread {

    private String username;
    private String status;
    private volatile int postsCount;
    private volatile boolean running = true;

    public SnapshotThread(String username, String status) {
        this.username = username;
        this.status = status;
        this.postsCount = 0;
        setDaemon(true);
    }

    public void updatePostsCount(int count) {
        this.postsCount = count;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        int snapshotNum = 1;
        while (running) {
            try {
                Thread.sleep(3000);
                UserProfile profile = new UserProfile(
                        username,
                        postsCount,
                        System.currentTimeMillis(),
                        status
                );
                String filename = "data/snapshots/profile_" + snapshotNum + ".ser";
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                    oos.writeObject(profile);
                }
                System.out.println("[Снапшот] Сохранён " + filename);
                snapshotNum++;
            } catch (InterruptedException e) {
                break;
            } catch (IOException e) {
                System.err.println("Ошибка снапшота: " + e.getMessage());
            }
        }
    }
}