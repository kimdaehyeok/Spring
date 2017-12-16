package com.spring.example.aop.xml.domain;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TrackOperation 
{
	public void myBeforeAdvice(JoinPoint jp) // it is advice
	{
		System.out.println("This is Before Advice Method");
	}
	
	public void myAfterAdvice(JoinPoint jp)
	{
		System.out.println("This is After Advice Method");
	}
	
	public void myAfterReturningAdvice(JoinPoint jp, int result)
	{
		System.out.println("After Returning Advice");
		System.out.println("Result : " + result);
	}
	
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("Around Start");
		Object object = pjp.proceed();
		System.out.println("Around End");
		
		return object;
	}
	
	public void myAfterThrowing(JoinPoint jp, Throwable error)
	{
		System.out.println("Exception : " + error);
	}
}