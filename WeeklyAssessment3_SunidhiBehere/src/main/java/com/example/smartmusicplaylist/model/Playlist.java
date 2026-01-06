package com.example.smartmusicplaylist.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-generated id for playlist
    private Long playlistId;
    
    private Long userId;
    
    private List<Long> songIds; // List of songIds

    // Constructors
    public Playlist() {}

    public Playlist(Long userId, List<Long> songIds) {
        this.userId = userId;
        this.songIds = songIds;
    }
    
    //Getters and Setters
    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<Long> songIds) {
        this.songIds = songIds;
    }
}
