package com.example.annoation.main;

import java.lang.reflect.Field;

import com.example.annoation.custom.FieldAnnotation.StringInjector;

public class FieldContextContainer {
	public FieldContextContainer() {
	}
	
	private <T> T invokeAnnotations(T instance) throws IllegalArgumentException, IllegalAccessException
	{
		Field[] fields = instance.getClass().getDeclaredFields();
		
		for(int i = 0; i < fields.length; i++)
		{
			StringInjector annotation = fields[i].getAnnotation(StringInjector.class);
			
			if(fields[i].getType() == String.class)
			{
				fields[i].setAccessible(true);
				fields[i].set(instance, annotation.value());
				
				System.out.println("Field Name is : " + fields[i]);
				
				System.out.println();
			}
			else
			{
				fields[i].setAccessible(true);
				fields[i].set(instance, annotation.index);
				
				System.out.println("Field Name is : " + fields[i]);
				System.out.println();
			}
		}
		
		return instance;
	}
	
	public <T> T getInstance(Class className) throws IllegalAccessException, InstantiationException
	{
        T instance = (T) className.newInstance();
        instance = invokeAnnotations(instance);
        return instance;
	}
}
