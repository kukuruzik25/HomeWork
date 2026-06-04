import model.AppConfig;
import java.io.*;

public class ConfigReader {

    private String filePath;

    public ConfigReader(String filePath) {
        this.filePath = filePath;
    }

    public AppConfig read() throws IOException {
        String username = "";
        int maxPosts = 0;
        String bio = "";
        char asciiChar = '@';
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String stroka;
            while ((stroka = reader.readLine()) != null) {
                if (stroka.trim().isEmpty() || stroka.trim().startsWith("#")) {
                    continue;
                }
                String[] parts = stroka.split("=", 2);
                if (parts.length != 2) continue;
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "username":
                        username = value;
                        break;
                    case "maxPosts":
                        maxPosts = Integer.parseInt(value);
                        break;
                    case "bio":
                        bio = value;
                        break;
                    case "asciiChar":
                        asciiChar = value.charAt(0);
                        break;
                }
            }
        }
        return new AppConfig(username, maxPosts, bio, asciiChar);
    }
}