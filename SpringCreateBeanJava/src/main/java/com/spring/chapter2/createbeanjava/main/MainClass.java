package com.spring.chapter2.createbeanjava.main;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.chapter2.createbeanjava.config.SpringAutowiredConfig;
import com.spring.chapter2.createbeanjava.config.SpringBeanConfig;
import com.spring.chapter2.createbeanjava.domain.AddHelloWorld;
import com.spring.chapter2.createbeanjava.domain.HelloWorld;

public class MainClass {

	public static void main(String[] args) 
	{
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
//		
//		HelloWorld helloworld = (HelloWorld) ctx.getBean("hello");
//		
//		helloworld.whoAmI();
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class, SpringAutowiredConfig.class);
		
		AddHelloWorld addHello = (AddHelloWorld) ctx.getBean("addHelloWorldObj");
		addHello.addHelloWhoami();
	}
}
