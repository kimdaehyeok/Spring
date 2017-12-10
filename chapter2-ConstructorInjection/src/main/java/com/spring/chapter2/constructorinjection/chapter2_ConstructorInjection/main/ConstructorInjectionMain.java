package com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.domain.Employee;

public class ConstructorInjectionMain 
{
    public static void main( String[] args )
    {
    		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    		
    		Employee employee = (Employee) context.getBean("employee");
    		
    		employee.show();
    }
}
