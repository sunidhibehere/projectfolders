package com.example.smartmusicplaylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartmusicplaylist.model.Song;

//extending JpaRepository for CRUD functionality for Songs
public interface SongRepository extends JpaRepository<Song, Long> {
}