package com.example.smartmusicplaylist.controller;

import com.example.smartmusicplaylist.model.Song;
import com.example.smartmusicplaylist.service.SongService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //Marks class SongController as RestController - returns JSON response
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

  //Handles HTTP post to create a new Song
    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    //Method Returns songs in the JSON format
    @GetMapping("/{id}")
    public Song getSong(@PathVariable Long id) {
        return songService.getSongById(id).orElseThrow(() -> new RuntimeException("Song not found"));
    }
    
  //Method Returns list of songs
    @GetMapping
    public List<Song> getAllSongs(){
		 return songService.getAllSongs();
	 }
}
