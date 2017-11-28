package com.example.spring.aop.main;

import java.lang.reflect.Proxy;

import com.example.spring.aop.domain.Calculator;
import com.example.spring.aop.domain.MyCalculator;
import com.example.spring.aop.proxy.MyCalculatorProxy;

public class AOPMain 
{
    public static void main( String[] args )
    {
    	Calculator cal = new MyCalculator();
    	
    	Calculator proxyCalculator = (Calculator) Proxy.newProxyInstance(cal.getClass().getClassLoader(), cal.getClass().getInterfaces(), new  MyCalculatorProxy(cal));
    	
    	System.out.println(proxyCalculator.add(3, 4));
    }
}
