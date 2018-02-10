package com.spring.example.handlerinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController 
{
	@RequestMapping("/error.do")
	public ModelAndView redirect()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect");
		
		return model;
	}
}
