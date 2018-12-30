package com.spring.example.aop.xml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.example.aop.xml.domain.Operation;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	
    	Operation operation = (Operation) context.getBean("opBean");

    	// Around 시 주석 처리
//    	operation.msg();
//    	System.out.println();
    	
    	operation.m();
    	System.out.println();
    	
    	operation.k();
    	System.out.println();
    	
    	System.out.println(operation.m());
    	System.out.println(operation.k());
    	
    	operation.validate(18);
    	
    }
}
