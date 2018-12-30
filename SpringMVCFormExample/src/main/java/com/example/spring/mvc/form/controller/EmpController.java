package com.example.spring.mvc.form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.mvc.form.vo.Employee;

@Controller
public class EmpController 
{
	@RequestMapping("/empform")
	public ModelAndView showForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("empform");
		//command is a reserved request attribute name, now use <form> tag to show object data  
		modelAndView.addObject("empObj", new Employee());
		
		return modelAndView;
	}
	
    @RequestMapping("/viewEmployee")  
    public ModelAndView viewEmployee()
    {  
        List<Employee> list=new ArrayList<Employee>();
        
        list.add(new Employee(1,"rahul",35000f,"S.Engineer"));  
        list.add(new Employee(2,"aditya",25000f,"IT Manager"));  
        list.add(new Employee(3,"sachin",55000f,"Care Taker"));  
          
        return new ModelAndView("viewemp","list",list);  
    }
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("empModelAttribute") Employee employee)
    {
    	System.out.println("get Parameters");
    	System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary() + " " + employee.getDesignation());
    	
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("empModelAttribute");
    	
    	return modelAndView;

    	//return new ModelAndView("empform2","empObj",employee);//will display object data
    }
}
