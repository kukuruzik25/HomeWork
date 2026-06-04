package model;
import java.io.Serializable;

public class Post implements Serializable {

    public int id;
    public long timestamp;
    public String text;

    public Post(int id, long timestamp, String text) {
        this.id = id;
        this.timestamp = timestamp;
        this.text = text;
    }
}