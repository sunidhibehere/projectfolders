package com.example.smartmusicplaylist.service;

import com.example.smartmusicplaylist.model.Playlist;
import com.example.smartmusicplaylist.repository.PlaylistRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//interaction with other services or repositories
@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    // Method to create a new playlist
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Method to add a song to a playlist
    public Playlist addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.getSongIds().add(songId);
        return playlistRepository.save(playlist);
    }

    //Method to get a playlist by Id
    public Playlist getPlaylist(Long id) {
        return playlistRepository.findById(id).orElseThrow(() -> new RuntimeException("Playlist not found"));
    }
    
    //Method to get all the playlists
    public List<Playlist> getAllPlaylists(){
    	return playlistRepository.findAll();
   	}
}
