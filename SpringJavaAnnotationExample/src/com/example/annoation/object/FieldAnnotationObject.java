package com.example.annoation.object;

import com.example.annoation.custom.FieldAnnotation.StringInjector;

public class FieldAnnotationObject
{
	@StringInjector("My Name is JDM")
	private String name;

	@StringInjector
	private String defaultName;

	@StringInjector
	private Integer invalidType;

	public String getName() 
	{
		return name;
	}

	public String getDefaultName()
	{
		return defaultName;
	}

	public Integer getInvalidType() 
	{
		return invalidType;
	}
}
