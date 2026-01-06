package com.example.smartmusicplaylist.controller;

import com.example.smartmusicplaylist.model.User;
import com.example.smartmusicplaylist.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //Marks class UserController as RestController - returns JSON response
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Handles HTTP post to create a new User
    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    //Returns user in the JSON format
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    //Returns the list of all Users
    @GetMapping
    public List<User> getAllUsers(){
		 return userService.getAllUsers();
	 }
}
