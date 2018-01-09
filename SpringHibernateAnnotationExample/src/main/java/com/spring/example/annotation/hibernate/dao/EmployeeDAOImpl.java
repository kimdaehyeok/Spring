package com.spring.example.annotation.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.example.annotation.hibernate.vo.Employee;

@Component("employeeDAO")
public class EmployeeDAOImpl //implements EmployeeDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insertEmployee(Employee employee) 
	{
		sessionFactory.getCurrentSession().save(employee);
	}

}
