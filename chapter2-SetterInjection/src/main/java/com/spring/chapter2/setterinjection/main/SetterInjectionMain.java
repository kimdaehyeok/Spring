package com.spring.chapter2.setterinjection.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.setterinjection.domain.Employee;

public class SetterInjectionMain 
{
    public static void main( String[] args )
    {
    		ApplicationContext context =  new ClassPathXmlApplicationContext("ApplicationContext.xml");
    		
    		Employee employee = (Employee) context.getBean("employee");
    		
    		employee.show();
    }
}
