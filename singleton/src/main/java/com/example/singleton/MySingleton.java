package com.example.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MySingleton {
//static instance
	private static MySingleton instance;
	
	private static final Logger logger = LogManager.getLogger(MySingleton.class);
	//private constructor prevents instantiation
	private MySingleton() {
		logger.info("Logger singleton instance created");
	}
	
	//public accessor with lazy initialization
	public static synchronized MySingleton getInstance() {
		if(instance==null) {
			instance = new MySingleton();
		}
		logger.debug("Returning logger singleton instance");
		return instance;
	}
	
	//example method
	public String sayHello() {
		return "Hello from Singleton";
	}
	
	
	public static void test() {
		System.out.println("Test Message");
	}
}
