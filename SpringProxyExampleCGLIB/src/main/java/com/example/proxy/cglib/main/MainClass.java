package com.example.proxy.cglib.main;

import com.example.proxy.cglib.domain.MethodInterceptorImpl;
import com.example.proxy.cglib.domain.PersonService;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/* Enhancer class allows us to create a proxy by dynamically
 * extending a PersonServiceClass by using a setSupercalss() method
 * */
public class MainClass 
{
    public static void main( String[] args )
    {	
   	Enhancer enhancer = new Enhancer();
    	enhancer.setSuperclass(PersonService.class);
    	enhancer.setCallback(new MethodInterceptorImpl());
    	
    	PersonService personService = (PersonService) enhancer.create();
    	
    	System.out.println("* Proxy Finish : " + personService.sayHello("KDH"));
    	
    }
}
