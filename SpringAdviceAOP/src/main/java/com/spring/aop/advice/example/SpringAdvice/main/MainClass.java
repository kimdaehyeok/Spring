package com.spring.aop.advice.example.SpringAdvice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.advice.example.SpringAdvice.domain.Calculator;

public class MainClass 
{
	public static void main(String[] args) 
	{
		
		/*Calculator cal = new myCalculator();
		Calculator proxy = Proxy.newProxyInstance(cal.getClass().getClassLoader(), cal.getClass().getInterfaces(), new LogPrintHandler(cal));*/
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		Calculator proxyCalculator = (Calculator) ctx.getBean("logProxy");
		
		proxyCalculator.add(3, 4);
		
	}
}
