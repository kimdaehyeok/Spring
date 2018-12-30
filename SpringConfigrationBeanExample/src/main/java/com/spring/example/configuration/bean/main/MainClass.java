package com.spring.example.configuration.bean.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.example.configuration.bean.config.HelloWorldConfig;
import com.spring.example.configuration.bean.vo.HelloWorld;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
    	
    	HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldBean");
    	helloWorld.setMessage("Test!");
    	helloWorld.printMessage();
    	
    	HelloWorld helloWorldBeanName = (HelloWorld) context.getBean("helloWorldBeanName");
    	helloWorldBeanName.setMessage("Set Message");
    	helloWorldBeanName.printMessage();
    }
}
