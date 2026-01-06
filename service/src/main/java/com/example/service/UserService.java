package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	public String createUser(String name) {
		System.out.println("Creating user: " + name);
		return name;
	}
	public String getUser() {
		return "John Doe";
	}
}
