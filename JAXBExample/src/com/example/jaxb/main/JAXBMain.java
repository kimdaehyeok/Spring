package com.example.jaxb.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.example.jaxb.domain.Customer;

public class JAXBMain 
{
	public static void main(String[] args) throws JAXBException 
	{
		Customer customer = new Customer();
		
		customer.setId(100);
		customer.setName("kdh");
		customer.setAge(27);
		
		createXML(customer);
		readXML();
	}

	public static void createXML(Customer customer) throws JAXBException
	{
		File file = new File("C:\\file.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); // 특정 데이터를 xml로 변환하는 것을 마샬링이라고 한다.
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		jaxbMarshaller.marshal(customer, file);
		jaxbMarshaller.marshal(customer, System.out);
	}
	
	public static void readXML() throws JAXBException
	{
		File file = new File("C:\\file.xml");
		
		JAXBContext jxabContext = JAXBContext.newInstance(Customer.class);
		
		Unmarshaller jaxbUnMarshaller = jxabContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnMarshaller.unmarshal(file);
		
		System.out.println("Age : " + customer.getAge());
		System.out.println("Name : " + customer.getName());
		System.out.println("Id : " + customer.getId());
				
	}
}