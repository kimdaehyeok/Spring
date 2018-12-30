package com.spring.chapter2.setterinjection.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question 
{
	private int id;
	private String name;
	private List<String> answerList;
	private List<Answer> answerListObj;
	private Map<String,String> answerMap;  
	private Map<Answer,User> answerObjMap;
	private Map<Integer,String> hashMapObj;
	
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
	public List<String> getAnswerList() 
	{
		return answerList;
	}
	public void setAnswerList(List<String> answerList)
	{
		this.answerList = answerList;
	}
	public List<Answer> getAnswerListObj() 
	{
		return answerListObj;
	}
	public void setAnswerListObj(List<Answer> answerListObj) 
	{
		this.answerListObj = answerListObj;
	}
	public Map<String, String> getAnswerMap()
	{
		return answerMap;
	}
	public void setAnswerMap(Map<String, String> answerMap)
	{
		this.answerMap = answerMap;
	}
	
	public Map<Answer, User> getAnswerObjMap()
	{
		return answerObjMap;
	}
	public void setAnswerObjMap(Map<Answer, User> answerObjMap) 
	{
		this.answerObjMap = answerObjMap;
	}
	public Map<Integer, String> getHashMapObj() {
		return hashMapObj;
	}
	public void setHashMapObj(Map<Integer, String> hashMapObj) {
		this.hashMapObj = hashMapObj;
	}
	
	public void show()
	{
		System.out.println(id + " " + name);
		
		Iterator<String> iter = answerList.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
	
	public void showListObj()
	{
		System.out.println(id + " " + name);
		
		for(Answer answer : answerListObj)
		{
			System.out.println(answer.getId() + " " + answer.getName() + " " + answer.getBy());
		}
	}
	
	public void showMap()
	{
		System.out.println(id + " " + name);
		
		for(Map.Entry<String, String> answer : answerMap.entrySet())
		{
			System.out.println(answer.getKey() + " " + answer.getValue());
		}
	}
	
	public void showObjMap()
	{
		System.out.println(id + " " + name);
		
		for(Map.Entry<Answer, User> answer : answerObjMap.entrySet())
		{
			System.out.println("==> key <==");
			System.out.println(answer.getKey().getId());
			System.out.println(answer.getKey().getName());
			System.out.println(answer.getKey().getBy());
			System.out.println("==> value <==");
			System.out.println(answer.getValue().getId());
			System.out.println(answer.getValue().getName());
			System.out.println(answer.getValue().getEmail());
		}
	}
	
	public void showHashMap()
	{
		Set set = hashMapObj.entrySet();
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry mentry = (Map.Entry)iterator.next();
	        System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	        System.out.println(mentry.getValue());

		}
	}
}
