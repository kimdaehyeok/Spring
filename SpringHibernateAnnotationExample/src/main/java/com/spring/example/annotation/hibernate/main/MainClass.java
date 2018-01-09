package com.spring.example.annotation.hibernate.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.example.annotation.hibernate.dao.EmployeeDAOImpl;
import com.spring.example.annotation.hibernate.vo.Employee;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    	// JDK Proxy를 사용한 경우.
//    	EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
//    
//    	Employee employee1 = new Employee();
//    	employee1.setId(3);W
//    	employee1.setName("KDH");
//    	employee1.setSalary(1000);
//    	
//    	employeeDAO.insertEmployee(employee1);
    	
    	// CGLib을 사용한 경우.
    	EmployeeDAOImpl employeeDAO = (EmployeeDAOImpl) context.getBean("employeeDAO");
    	
    	Employee employee1 = new Employee();
    	employee1.setId(3);
    	employee1.setName("KDH");
    	employee1.setSalary(1000);
    	
    	employeeDAO.insertEmployee(employee1);
    }
}
