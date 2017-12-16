package com.spring.chapter2.setterinjection.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.setterinjection.domain.Employee;
import com.spring.chapter2.setterinjection.domain.Question;

public class MainClass {
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		Employee employee = (Employee) context.getBean("employee");
		employee.show();
		System.out.println();

		Employee employeeAddress = (Employee) context.getBean("employeeAddress");
		employeeAddress.showAddress();
		System.out.println();

		Question qustionList = (Question) context.getBean("listAnser");
		qustionList.show();
		System.out.println();

		Question qustionListObj = (Question) context.getBean("questionListObj");
		qustionListObj.showListObj();
		System.out.println();

		Question questionMap = (Question) context.getBean("questionMap");
		questionMap.showMap();
		System.out.println();

		Question questionObjMap = (Question) context.getBean("questionObjMap");
		questionObjMap.showObjMap();
		System.out.println();

		Question questionHshMap = (Question) context.getBean("hashMapObj");
		questionHshMap.showHashMap();
	}
}
