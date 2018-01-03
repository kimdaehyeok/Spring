package com.spring.example.importannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.example.importannotation.config.ImportConfig;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
//    	ApplicationContext context = new AnnotationConfigApplicationContext(ChildConfig.class);
    	
    	String str1 = (String) context.getBean("hello");
    	String str2 = (String) context.getBean("world");
    	
    	System.out.println(str1);
    	System.out.println(str2);
    }
}
