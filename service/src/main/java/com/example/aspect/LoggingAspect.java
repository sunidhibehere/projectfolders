package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(* com.example.service.*.*(..))")
	public void serviceModels() {}

	@Before("serviceMethods()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before method: " + joinPoint.getSignature().getName());
	}
	
	@After("serviceMethids()")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After method: " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut = "ServiceModels()",returning="result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("Method: " + joinPoint.getSignature().getName() + "returned: "+result);
	}
	
	@AfterThrowing(pointcut = "ServiceModels()",throwing="error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("Method: " + joinPoint.getSignature().getName() + "threw: "+error);
	}
}