package model;

import annotations.DefaultValue;
import annotations.MaxLength;
import annotations.Required;

public class UserProfile {
    @Required @MaxLength(20)
    private String username;

    @Required
    private String email;

    @MaxLength(150)
    private String bio;

    @DefaultValue("Не указана")
    private String country;

    @DefaultValue("user")
    private String role;

    public UserProfile(String username, String email, String bio, String country, String role) {
        this.username = username;
        this.email    = email;
        this.bio      = bio;
        this.country  = country;
        this.role     = role;
    }
}