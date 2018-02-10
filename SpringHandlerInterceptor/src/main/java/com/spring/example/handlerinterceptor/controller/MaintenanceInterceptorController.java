package com.spring.example.handlerinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MaintenanceInterceptorController 
{
	@RequestMapping("maintenanceInterceptor.do")
	@ResponseBody
	public String maintenanceInterceptor()
	{
		return "maintenanceInterceptor";
	}
}
