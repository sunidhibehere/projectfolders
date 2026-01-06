package com.example.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterPatternTest {
	@Test
	void testSmartwatchAdapterWithNormalSteps() {
		LegacyStepCounter legacyCounter = new LegacyStepCounter(5000);
		
		FitnessTracker tracker = new SmartwatchAdapter(legacyCounter);
		
		assertEquals(5000,tracker.trackSteps(),"Steps should match legacy counter");
		assertEquals(200,tracker.trackCalories(),"Calories should be steps * 0.04");
	}
	
	@Test
	void testSmartwatchAdapterWithZeroSteps() {
		LegacyStepCounter legacyCounter = new LegacyStepCounter(0);
		FitnessTracker tracker = new SmartwatchAdapter(legacyCounter);
		
		assertEquals(0,tracker.trackSteps(),"Steps should be zero");
		assertEquals(0,tracker.trackCalories(),"Calories should also be zero");	
	}
	
	@Test
	void testSmartwatchAdapterWithNegativeSteps() {
		LegacyStepCounter legacyCounter = new LegacyStepCounter(-100);
		FitnessTracker tracker = new SmartwatchAdapter(legacyCounter);
		
		assertEquals(-100,tracker.trackSteps(),"Steps should reflect negative input");
		assertEquals(-4,tracker.trackCalories(),"Calories should be negative if steps are negative");	
	}
	
	@Test
	void testSmartwatchAdapterWithLargeSteps() {
		LegacyStepCounter legacyCounter = new LegacyStepCounter(1_000_000);
		FitnessTracker tracker = new SmartwatchAdapter(legacyCounter);
		
		assertEquals(1_000_000,tracker.trackSteps(),"Steps should match input");
		assertEquals(40_000,tracker.trackCalories(),"Calories should scale correctly");	
	}
	
	@Test
	void testFitnessAppIntegration() {
		LegacyStepCounter legacyCounter = new LegacyStepCounter(2500);
		FitnessTracker tracker = new SmartwatchAdapter(legacyCounter);
		
		assertEquals(2500,tracker.trackSteps());
		assertEquals(100,tracker.trackCalories());	
	}
}
