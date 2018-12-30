package com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Question 
{
	private int id;
	private String name;
	private List<Answer> answersList;
	private Map<String,String> answersMap;
	private Map<Answer,User> answerObjectMap;
	
	public Question(int id, String name, List<Answer> answersList)
	{
		this.id = id;
		this.name = name;
		this.answersList = answersList;
	}
	
	public Question(int id, String name, Map<String,String> answersMap)
	{
		this.id = id;
		this.name = name;
		this.answersMap = answersMap;
	}
	
	public Question(String name, Map<Answer,User> answerObjectMap)
	{
		this.name = name;
		this.answerObjectMap = answerObjectMap;
	}
	
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
	public List<Answer> getAnswers() 
	{
		return answersList;
	}
	public void setAnswers(List<Answer> answers) 
	{
		this.answersList = answers;
	}
	
	public void showList()
	{
		System.out.println(id + " " + name);
		Iterator<Answer> iterator = answersList.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	
	public void showMap()
	{
		System.out.println(id + " " + name);
		
		for(Map.Entry<String, String> map : answersMap.entrySet())
		{
			System.out.println(map.getKey() + " " + map.getValue());
		}
	}
	
	public void showObjectMap()
	{
		for(Map.Entry<Answer, User> map : answerObjectMap.entrySet())
		{
			System.out.println("==> Get Key Start");
			System.out.println(map.getKey().getId());
			System.out.println(map.getKey().getName());
			System.out.println(map.getKey().getBy());
			System.out.println("==> Get Value Start");
			System.out.println(map.getValue().getId());
			System.out.println(map.getValue().getName());
			System.out.println(map.getValue().getEmail());
			System.out.println();
		}
	}
}
