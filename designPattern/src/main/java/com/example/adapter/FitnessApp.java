package com.example.adapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FitnessApp {
	private static final Logger logger = LoggerFactory.getLogger(FitnessApp.class);
	
	private final FitnessTracker tracker;
	
	public FitnessApp(FitnessTracker tracker) {
		this.tracker = tracker;
		logger.info("FitnessApp initialized with FitnessTracker");
	}
	
	public void displayStats() {
		logger.info("Displaying stats...");
		logger.info("Steps: {}",tracker.trackSteps());
		logger.info("Calories: {}",tracker.trackCalories());
	}
}
