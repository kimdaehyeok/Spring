package com.spring.example.spel.domain;

public class Item 
{
	private String name;
	private int qty;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getQty() 
	{
		return qty;
	}
	public void setQty(int qty) 
	{
		this.qty = qty;
	}
	
	public String whoAmI()
	{
		return "Item Class";
	}
}
