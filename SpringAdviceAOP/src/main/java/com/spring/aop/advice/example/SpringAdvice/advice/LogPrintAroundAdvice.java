package com.spring.aop.advice.example.SpringAdvice.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.LogFactory;

public class LogPrintAroundAdvice implements MethodInterceptor
{
	@Override
	public Object invoke(MethodInvocation method) throws Throwable 
	{
		System.out.println("Proxy Obejct Start");
		
		Object result = method.proceed();
		
		System.out.println("Proxy Object End");
		
		return result;
	}
}
