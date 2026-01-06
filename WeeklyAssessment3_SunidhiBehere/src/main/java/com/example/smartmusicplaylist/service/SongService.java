package com.example.smartmusicplaylist.service;

import com.example.smartmusicplaylist.model.Song;
import com.example.smartmusicplaylist.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//interaction with other services or repositories
@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    // Method to add a new song
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    // Method to get song by ID
    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }
    
  //Method to get the list of all songs
    public List<Song> getAllSongs(){
    	return songRepository.findAll();
   	}
}
