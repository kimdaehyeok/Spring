package com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.domain.Employee;
import com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.domain.Question;

public class ConstructorInjectionMain 
{
    public static void main( String[] args )
    {
    		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    		
    		Employee employee = (Employee) context.getBean("employee");
    		employee.show();
    		System.out.println();
    		
    		Employee addressEmp = (Employee) context.getBean("addressEmployee");
    		addressEmp.addressShow();
    		System.out.println();
    		
    		Employee listEmp = (Employee) context.getBean("listEmployee");
    		listEmp.listShow();
    		System.out.println();
    		
    		Question questionList = (Question) context.getBean("questionList");
    		questionList.showList();
    		System.out.println();
    		
    		Question questionMap = (Question) context.getBean("questionMap");
    		questionMap.showMap();
    		System.out.println();
    		
    		Question questionObjMap = (Question) context.getBean("questionObjectMap");
    		questionObjMap.showObjectMap();
    		System.out.println();
    		
    		Employee inheritEmployee = (Employee) context.getBean("inheritEmployee");
    		inheritEmployee.inheritShow();
    		System.out.println();
    		
    }
}
