package com.spring.example.annotation.hibernate.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* @Entity : 엔티티 클래스임을 지정하며, 테이블과 매핑된다.
 * @Table : 엔티티가 매핑될 테이블을 지정하고, 생략시 엔티티 클래스 이름과 같은 테이블로 매핑된다.
 * @Column : 어노테이션은 컬럼의 이름을 이용하여 지정된 필드나 속성을 테이블 컬럼에 매핑한다.
 * */

@Entity
@Table(name = "EMP558")
public class Employee 
{
	@Id
	@Column(name = "ID", nullable = false)
	private int id;  
	
	@Column(name = "NAME", nullable = false)
	private String name;  
	
	@Column(name = "SALARY", nullable = false)
	private float salary;

	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public float getSalary() 
	{
		return salary;
	}

	public void setSalary(float salary) 
	{
		this.salary = salary;
	}  
}
