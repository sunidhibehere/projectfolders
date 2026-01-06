package com.example.smartmusicplaylist.controller;

import com.example.smartmusicplaylist.model.Playlist;
import com.example.smartmusicplaylist.service.PlaylistService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //Marks class PlaylistController as RestController - returns JSON response
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    //Handles HTTP post to create a new Playlist
    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    //put songs to specific playlist
    @PutMapping("/{id}/addSong/{songId}")
    public Playlist addSongToPlaylist(@PathVariable Long id, @PathVariable Long songId) {
        return playlistService.addSongToPlaylist(id, songId);
    }

    //Returns playlists in the JSON format
    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylist(id);
    }
    
    //Method to return all playlists
    @GetMapping
    public List<Playlist> getAllPlaylists(){
		 return playlistService.getAllPlaylists();
	 }
}
