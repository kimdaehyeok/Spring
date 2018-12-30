package com.spring.example.handlerinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UrlInterceptorController 
{
	@RequestMapping("/urlInterceptor.do")
	@ResponseBody
	public String urlInterceptor()
	{
		return "This is URL Interceptor";
	}
}
