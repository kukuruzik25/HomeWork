import java.io.*;

public class AvatarRenderer {

    private String avatarPath;

    public AvatarRenderer(String path) {
        this.avatarPath = path;
    }

    public void render() throws IOException {
        try (FileReader reader = new FileReader(avatarPath)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        }
        System.out.println();
        try (FileInputStream in = new FileInputStream(avatarPath);
             FileOutputStream out = new FileOutputStream("data/avatar_backup.jpg")) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        System.out.println("Аватар показан и скопирован в data/avatar_backup.txt");
    }
}