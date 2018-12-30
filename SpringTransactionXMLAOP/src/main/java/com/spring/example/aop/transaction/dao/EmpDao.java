package com.spring.example.aop.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.example.aop.transaction.vo.Employee;

/* 프록시 객체를 생성하는 방법은 대상 객체가 인터페이스를 구현하고 있느냐 없느냐 여부에 따라 달라진다.
 * 대상 객체가 인터페이스를 구현하고 있다면 스프링은 자바 리플렉션 API를 통해 프록시 객체를 생헝한다.
 * 이때 생성된 프록시 객체는 대상 객체와 동일한 인터페이스를 구현하게되며 클라이언트는 인터페이스를 통해 메소드를 호출한다.
 * 인터페이스에 정의되지 않은 메소드는 AOP가 동작하지 않는다.
 * */
public class EmpDao //implements EmpInterface
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void updateEmployee(String job)
	{
		String query = "UPDATE SCOTT.EMP SET JOB = '" +job +" ' WHERE ENAME = 'BLAKE' ";
		
		jdbcTemplate.update(query);
	}
}
