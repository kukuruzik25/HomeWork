package model;
import java.io.Serializable;

public class UserProfile implements Serializable {

    public String username;
    public int postsWritten;
    public long lastActiveTimestamp;
    public String status;

    public UserProfile(String username, int postsWritten, long lastActiveTimestamp, String status) {
        this.username = username;
        this.postsWritten = postsWritten;
        this.lastActiveTimestamp = lastActiveTimestamp;
        this.status = status;
    }
}