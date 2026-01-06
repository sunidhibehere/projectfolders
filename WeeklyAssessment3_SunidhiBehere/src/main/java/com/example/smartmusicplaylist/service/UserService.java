package com.example.smartmusicplaylist.service;

import com.example.smartmusicplaylist.model.User;
import com.example.smartmusicplaylist.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//interaction with other services or repositories
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
 
    // Method to register a new user
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Method to get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
     
    //Method to get the list of all users
    public List<User> getAllUsers(){
    	return userRepository.findAll();
   	}
}