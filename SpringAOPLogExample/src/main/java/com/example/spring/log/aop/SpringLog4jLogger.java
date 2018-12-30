package com.example.spring.log.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class SpringLog4jLogger 
{
	private static Logger logger = Logger.getLogger("SpringLog4jLogger.class");
	
	public void beforeLogMethod(JoinPoint joinPoint) throws Throwable //Advice
	{
		System.out.println("Before Log Method");
		System.out.println(joinPoint.getSignature().getName());
	}
}
