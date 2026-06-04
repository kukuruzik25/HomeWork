package model;
import java.io.Serializable;

public class Achievement implements Serializable {

    public String emoji;
    public String title;
    public String description;
    public long unlockedAt;

    public Achievement(String emoji, String title, String description, long unlockedAt) {
        this.emoji = emoji;
        this.title = title;
        this.description = description;
        this.unlockedAt = unlockedAt;
    }

    @Override
    public String toString() {
        return emoji + " " + title + " (" + description + ")";
    }
}
