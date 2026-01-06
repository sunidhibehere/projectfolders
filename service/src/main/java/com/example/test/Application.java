package com.example.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.AppConfig;
import com.example.service.UserService;

public class Application {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService userService = context.getBean(UserService.class);
		
		userService.createUser("Alice");
		System.out.println(userService.getUser());
		
		context.close();
	}
}
