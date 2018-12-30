package com.spring.chapter2.setterinjection.domain;

public class Employee 
{
	private int id;
	private String name;
	private String city;
	private Address address;
	
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
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address getAddress() 
	{
		return address;
	}
	public void setAddress(Address address)
	{
		this.address = address;
	}
	public void show()
	{
		System.out.println(id + " " + name + " " + city);
	}
	
	public void showAddress()
	{
		System.out.println(id + " " + name + " " + city);
		System.out.println(address.getCity() + " " + address.getCountry() + " " +  address.getState() + " " +  address.getAddressLine1());
	}
}
