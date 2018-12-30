package com.spring.example.hibernate.dao;

import java.util.List;

import com.spring.example.hibernate.vo.Employee;

public interface DaoInterface
{
	public void saveEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(Employee e);
	public Employee getById(int id);
	public List<Employee> getEmployees();
}
