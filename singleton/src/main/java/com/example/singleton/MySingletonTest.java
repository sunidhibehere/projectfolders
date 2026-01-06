package com.example.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MySingletonTest {
	
	@Test
	void testSingletonInstance() {
		MySingleton s1 = MySingleton.getInstance();
		MySingleton s2 = MySingleton.getInstance();
		
		//verify both references point to same object
		assertSame(s1,s2,"Instances should be the same");
	}
	
	@Test
	void testSayHello() {
		MySingleton singleton = MySingleton.getInstance();
		String message = singleton.sayHello();
		
		assertEquals("Hello from Singleton!",message);
	}
	
	@Test
	void testNotNullInstance() {
		MySingleton singleton = MySingleton.getInstance();
		assertNotNull(singleton, "Singleton instance should not be null");
	}
	
	@Test
	void testMultipleCallsReturnsSameInstance() {
		MySingleton first = MySingleton.getInstance();
		for(int i=0;i<10;i++) {
			MySingleton next = MySingleton.getInstance();
			assertSame(first,next,"All calls should return the same instance");
		}
	}
	
	@Test
	void testSingletonMethodConsistency() {
		MySingleton singleton = MySingleton.getInstance();
		String result1 = singleton.sayHello();
		String result2 = singleton.sayHello();
		
		assertEquals(result1,result2,"Method should consistently return the same result");
	}
	
}
