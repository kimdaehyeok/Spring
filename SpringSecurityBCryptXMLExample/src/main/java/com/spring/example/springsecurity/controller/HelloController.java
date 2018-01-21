package com.spring.example.springsecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
{
	@RequestMapping(value = "/")
	public ModelAndView indexPage()
	{

		ModelAndView model = new ModelAndView(); 
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping(value = "/user**" )
	public ModelAndView welcomePage() 
	{

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**")
	public ModelAndView adminPage() 
	{

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error
			,@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView(); 
		
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) 
		{
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = "/accessDenied")
	public ModelAndView accessDeny()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("accessDeny");
		
		return model;
	}
	
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		
		if (exception instanceof BadCredentialsException)
		{
			error = "Invalid username and password!";
		}
		else if (exception instanceof LockedException)
		{
			error = exception.getMessage();
		} 
		else 
		{
			error = "Invalid username and password!";
		}

		return error;
	}
}
