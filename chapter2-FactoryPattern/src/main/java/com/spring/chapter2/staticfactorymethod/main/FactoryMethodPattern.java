package com.spring.chapter2.staticfactorymethod.main;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.staticfactorymethod.dao.FixDepositDaoInterface;

public class FactoryMethodPattern
{
	
	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("src/main/resources/META-INF/log4j.properties");

		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:META-INF/spring/ApplicationContext.xml");
		
		FixDepositDaoInterface fixDepositDao = (FixDepositDaoInterface) context.getBean("staticDao");
		fixDepositDao.printWhoAmI();
	}
	
}
