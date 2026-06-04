import model.Post;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PostSaver implements Runnable {
    private PipedInputStream pipeIn;
    private List<Post> allPosts = new ArrayList<>();

    public PostSaver(PipedInputStream pipeIn) {
        this.pipeIn = pipeIn;
    }

    @Override
    public void run() {
        try (ObjectInputStream objIn = new ObjectInputStream(pipeIn)) {
            while (true) {
                try {
                    Post post = (Post) objIn.readObject();
                    allPosts.add(post);
                    System.out.println("[Сохранён] Пост #" + post.id + ": " + post.text);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }
        try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream("data/posts.dat"))) {
            fileOut.writeObject(allPosts);
            System.out.println("Все посты сохранены в data/posts.dat");
        } catch (IOException e) {
            System.err.println("Ошибка сохранения posts.dat: " + e);
        }
    }

    public List<Post> getAllPosts() {
        return allPosts;
    }
}