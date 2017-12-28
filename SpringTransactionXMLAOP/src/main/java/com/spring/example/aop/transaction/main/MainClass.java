package com.spring.example.aop.transaction.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.example.aop.transaction.dao.EmpDao;
import com.spring.example.aop.transaction.dao.EmpInterface;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	
    	// 인터페이스 상속을 받은 경우
//    	EmpInterface empDao = (EmpInterface) context.getBean("empDao");
//    	empDao.updateEmployee("Jobs!");
    
    	// 인터페이스 상속을 받지 않은 경우
    	EmpDao empDao2 = (EmpDao) context.getBean("empDao");
    	empDao2.updateEmployee("Jobs!");
    }
}
