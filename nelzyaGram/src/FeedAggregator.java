import java.io.*;
import java.util.*;

public class FeedAggregator implements Runnable {

    private String file1;
    private String file2;

    public int totalPosts = 0;
    public int totalLikes = 0;
    public int totalReposts = 0;
    public String topAuthor = "";
    public int topLikes = 0;
    public Map<String, Integer> authorLikes = new HashMap<>();
    public List<String> top5Activity = new ArrayList<>();

    public FeedAggregator(String f1, String f2) {
        this.file1 = f1;
        this.file2 = f2;
    }

    private void processFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    String author = parts[0];
                    int likes = Integer.parseInt(parts[2]);
                    int reposts = Integer.parseInt(parts[3]);

                    totalPosts++;
                    totalLikes += likes;
                    totalReposts += reposts;

                    authorLikes.put(author, authorLikes.getOrDefault(author, 0) + likes);
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            processFile(file1);
            processFile(file2);
            for (Map.Entry<String, Integer> entry : authorLikes.entrySet()) {
                if (entry.getValue() > topLikes) {
                    topLikes = entry.getValue();
                    topAuthor = entry.getKey();
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(authorLikes.entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            top5Activity.clear();
            int count = 0;
            for (Map.Entry<String, Integer> entry : list) {
                if (count++ >= 5) break;
                top5Activity.add(entry.getKey() + " — " + entry.getValue() + " лайков");
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }
    }
}