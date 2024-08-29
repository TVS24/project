package com.policy.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.policy..*(..))")
	public void logBeforeMethod(JoinPoint joinPoint) {
		logger.info("Entering method: {} with arguments: {}",joinPoint.getSignature(),joinPoint.getArgs());
	}
	
	@AfterReturning(pointcut = "Execution(* com.policy..*(..))", returning = "result")
	public void logAfterMethod(JoinPoint joinPoint, Object result) {
		logger.info("Exiting method: {} with result: {}",joinPoint.getSignature(),result);
	}
	
	@AfterThrowing(pointcut = "Execution(* com.policy..*(..))",throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.error("Exception in method: {} with cause: {}",joinPoint.getSignature(),error.getMessage());
	}
}
