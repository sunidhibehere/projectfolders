package com.example.smartmusicplaylist.model;

import jakarta.persistence.*;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Used for autogenerating unique userIds
    private Long userId;
    
    @Column(nullable=false)
    private String username;
    
    @Column(nullable=false)
    private String email;

    // Constructors
    public User() {}
    
    public User(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}