package com.spring.example.properties.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.example.properties.domain.DatabaseUser;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	
    	DatabaseUser dbUser = (DatabaseUser) context.getBean("databaseUser");
    	dbUser.show();
    }
}
