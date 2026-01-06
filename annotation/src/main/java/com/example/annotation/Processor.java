package com.example.annotation;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Processor {
	@Value("${processor.model}")
	private String model;
	
	public String getModel() {
		return model;
	}
	
}
