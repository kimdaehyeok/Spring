package com.example.spring.log.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring.log.dto.Calculator;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	
    	Calculator calculator = (Calculator) context.getBean("calculator");
    	calculator.add(3, 5);
    }
}
