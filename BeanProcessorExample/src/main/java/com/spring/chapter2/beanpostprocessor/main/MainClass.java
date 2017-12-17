package com.spring.chapter2.beanpostprocessor.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.beanpostprocessor.domain.Customer;

/*
 * In Spring, you can either implements InitializingBean and DisposableBean interface
 * or specify the init-method and destroy-method in bean configuration file
 * for the initialization and destruction callback function.
 * we show you how to use annotation @PostConstruct and @PreDestroy to do the same thing.
 */

/*
 * By default, Spring will not aware of the @PostConstruct and @PreDestroy annotation
 * The @PostConstruct and @PreDestroy annotation are not belong to Spring, 
 * it’s located in the J2ee library – common-annotations.jar.
 * To enable it, you have to either register 'CommonAnnotationBeanPostProcessor'
 * or specify the'<context:annotation-config />' in bean configuration file
 */

public class MainClass 
{
    public static void main( String[] args )
    {
    		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    		
    		Customer customer = (Customer) context.getBean("customerService");
    		
    		System.out.println(customer);
    		
    		((ClassPathXmlApplicationContext) context).close();
    		
    }
}
