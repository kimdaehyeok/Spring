package com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.domain;

public class Address
{
	private String city;
	private String state;
	private String country;
	private String addressLine1;
	
	public Address(String city, String state, String county)
	{
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public Address(String addressLine1, String city, String state, String country) 
	{  
	    super();  
	    this.addressLine1 = addressLine1;  
	    this.city = city;  
	    this.state = state;  
	    this.country = country;  
	}
	
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	public String getCountry() 
	{
		return country;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}
	
	public String toString()
	{  
	    return addressLine1 + " "+ city + " " + state + " " + country;  
	}  
}
