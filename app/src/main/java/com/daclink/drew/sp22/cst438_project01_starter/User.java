package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public Integer uid;
    private String username;
    private String password;
    @NonNull
    private String newsSource;

    public User() {
        newsSource = "";
    }

    public User(String username, String password, @NonNull String newsSource) {
        this.username = username;
        this.password = password;
        this.newsSource = newsSource;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        newsSource = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    @NonNull
    public String toString() {
        return "Username: " + this.username +
                "  Password: " + this.password;
    }
}
