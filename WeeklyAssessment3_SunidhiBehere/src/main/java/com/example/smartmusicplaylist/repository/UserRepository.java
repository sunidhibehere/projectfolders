package com.example.smartmusicplaylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartmusicplaylist.model.User;

//extending JpaRepository for CRUD functionality for Users
public interface UserRepository extends JpaRepository<User, Long> {
}
