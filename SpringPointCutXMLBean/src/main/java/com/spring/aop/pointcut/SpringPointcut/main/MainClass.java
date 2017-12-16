package com.spring.aop.pointcut.SpringPointcut.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.pointcut.SpringPointcut.domain.Calculator;

public class MainClass 
{
    public static void main( String[] args )
    {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		Calculator proxyCalculator = (Calculator) ctx.getBean("proxy");
		
		proxyCalculator.add(3, 4);
		System.out.println();
		
		proxyCalculator.divide(4, 2);
		System.out.println();
		
		proxyCalculator.multiply(3, 4);
		System.out.println();
		
		proxyCalculator.subtract(4, 3);
    }
}
