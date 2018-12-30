package com.example.spring.dao;

import com.example.spring.vo.EmployeeVo;

public class EmployeeVoDao 
{
	public EmployeeVo createNewEmployee()
    {
		EmployeeVo employee = new EmployeeVo();
        employee.setId(1);
        employee.setFirstName("Lokesh");
        employee.setLastName("Gupta");
        return employee;
    }
     
    public void initBean() {
        System.out.println("Init Bean for : EmployeeDAOImpl");
    }
     
    public void destroyBean() {
        System.out.println("Init Bean for : EmployeeDAOImpl");
    }
}
