package com.example.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyCalculatorProxy implements InvocationHandler
{
	private Object target;
	
	public MyCalculatorProxy(Object target)
	{
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Proxy 시작");
		
		int result =  (Integer) method.invoke(target, args);
		
		System.out.println("Proxy 끝");
		
		return result;
	}

}
