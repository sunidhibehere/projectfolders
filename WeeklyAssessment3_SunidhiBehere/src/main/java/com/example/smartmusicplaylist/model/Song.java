package com.example.smartmusicplaylist.model;

import jakarta.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-generating id for songs
    private Long songId;

    @Column(nullable=false)
    private String title;
    
    @Column(nullable=false)
    private String artist;
    
    @Column(nullable=false)
    private int duration; // Duration in seconds

    // Constructors
    public Song() {}

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    
    //Getters and Setters
	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
