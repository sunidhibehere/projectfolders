package com.example.adapter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LegacyStepCounter {
	private static final Logger logger = LoggerFactory.getLogger(LegacyStepCounter.class);
	private int steps;
	
	public LegacyStepCounter(int steps) {
		this.steps=steps;
		logger.info("LegacyStepCounter initialized with steps = {} ",steps);
	}
	
	public int countSteps() {
		logger.debug("Counting steps: {}", steps);
		return steps;
	}
}
