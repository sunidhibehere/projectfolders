package com.example.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartwatchAdapter implements FitnessTracker{
	private static final Logger logger = LoggerFactory.getLogger(SmartwatchAdapter.class);
	private final LegacyStepCounter legacyCounter;
	
	public SmartwatchAdapter(LegacyStepCounter legacyCounter) {
		this.legacyCounter = legacyCounter;
		logger.info("Smartwatch adapter created for LegacyStepCounter");
	}
	
	
	public int trackSteps() {
		int steps = legacyCounter.countSteps();
		logger.info("Adapted steps = {}",steps);
		return steps;
	}
	
	public int trackCalories() {
		int calories = (int)(legacyCounter.countSteps()*0.04);
		logger.info("Calculated calories = {}",calories);
		return calories;
	}
}
