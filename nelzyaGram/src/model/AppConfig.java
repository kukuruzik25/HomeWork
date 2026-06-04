package model;

public class AppConfig {

    public String username;
    public int maxPosts;
    public String bio;
    public char asciiChar;

    public AppConfig(String username, int maxPosts, String bio, char asciiChar) {
        this.username = username;
        this.maxPosts = maxPosts;
        this.bio = bio;
        this.asciiChar = asciiChar;
    }
}