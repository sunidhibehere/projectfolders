package com.example.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	private Processor processor;
	
	@Autowired
	public Laptop(Processor processor) {
		this.processor = processor;
	}
	
	public void showSpecs() {
		System.out.println("Laptop runs on: " + processor.getModel());
	}
}
