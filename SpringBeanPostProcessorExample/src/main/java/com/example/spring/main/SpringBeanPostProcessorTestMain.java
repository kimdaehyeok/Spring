package com.example.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanPostProcessorTestMain 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("com/example/spring/resources/beans.xml");
	}
}
