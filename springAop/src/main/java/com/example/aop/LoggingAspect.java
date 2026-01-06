package com.example.aop;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("[LOG] Before: "+ joinPoint.getSignature());
	}
	
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("[LOG] After: "+ joinPoint.getSignature());
	}
}
