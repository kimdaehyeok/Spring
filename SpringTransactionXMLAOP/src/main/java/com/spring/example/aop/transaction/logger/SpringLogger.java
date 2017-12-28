package com.spring.example.aop.transaction.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class SpringLogger 
{
	private static Logger logger = Logger.getLogger("SpringLogger.class");
	
	public void beforeLogMethod(JoinPoint joinPoint) throws Throwable //Advice
	{
	}
}
