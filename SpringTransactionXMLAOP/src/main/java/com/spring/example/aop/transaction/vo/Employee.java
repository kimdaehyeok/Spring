package com.spring.example.aop.transaction.vo;

public class Employee 
{
	private int empNo;
	private String eName;
	private String job;
	private String mgr;
	
	public int getEmpNo() 
	{
		return empNo;
	}
	public void setEmpNo(int empNo) 
	{
		this.empNo = empNo;
	}
	public String geteName() 
	{
		return eName;
	}
	public void seteName(String eName) 
	{
		this.eName = eName;
	}
	public String getJob() 
	{
		return job;
	}
	public void setJob(String job) 
	{
		this.job = job;
	}
	public String getMgr() 
	{
		return mgr;
	}
	public void setMgr(String mgr) 
	{
		this.mgr = mgr;
	}
	
	
}
