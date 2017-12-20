package com.example.proxy.cglib.domain;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MethodInterceptorImpl implements MethodInterceptor
{

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		System.out.println("=> Method : " + method.getName());
		System.out.println("=> Obj : " + obj.getClass().getName());
		
		System.out.println("* Proxy Start");
		
		return proxy.invokeSuper(obj, args);
	}
}
