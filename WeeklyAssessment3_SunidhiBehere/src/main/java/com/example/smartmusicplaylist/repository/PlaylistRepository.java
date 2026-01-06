package com.example.smartmusicplaylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartmusicplaylist.model.Playlist;

//extending JpaRepository for CRUD functionality for Playlists
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}