package com.spring.example.hibernate.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.example.hibernate.dao.DaoInterface;
import com.spring.example.hibernate.vo.Employee;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	
    	// CGLib을 사용한 경우
//    	EmployeeDao dao = (EmployeeDao) context.getBean("employeeDao");
//    	
//    	Employee e = new Employee();  
//        e.setId(114);  
//        e.setName("varun");  
//        e.setSalary(50000);  
//          
//        dao.saveEmployee(e);  
    	
    	DaoInterface dao = (DaoInterface) context.getBean("employeeDao");
    	
    	Employee e = new Employee();  
    	e.setId(114);  
    	e.setName("varun");  
    	e.setSalary(50000);  
        
    	dao.saveEmployee(e); 
    	
    }
}
