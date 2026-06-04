import model.AppConfig;
import model.Post;
import java.io.*;
import java.util.Scanner;

public class PostWriter implements Runnable {
    private AppConfig config;
    private PipedOutputStream pipeOut;
    private int postId = 1;

    public PostWriter(AppConfig config, PipedOutputStream pipeOut) {
        this.config = config;
        this.pipeOut = pipeOut;
    }

    @Override
    public void run() {
        try (ObjectOutputStream objOut = new ObjectOutputStream(pipeOut);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Пиши посты (максимум " + config.maxPosts + "). Для выхода напиши 'exit':");

            int postsWritten = 0;
            while (postsWritten < config.maxPosts) {
                System.out.print("> ");
                String text = scanner.nextLine();
                if (text.equalsIgnoreCase("exit")) {
                    break;
                }

                Post post = new Post(postId++, System.currentTimeMillis(), text);
                objOut.writeObject(post);
                objOut.flush();
                postsWritten++;

                System.out.println("Пост отправлен на сохранение!");
            }

        } catch (IOException e) {
            System.err.println("Ошибка в PostWriter: " + e.getMessage());
        } finally {
            try {
                pipeOut.close();
            } catch (IOException e) {}
        }
    }
}