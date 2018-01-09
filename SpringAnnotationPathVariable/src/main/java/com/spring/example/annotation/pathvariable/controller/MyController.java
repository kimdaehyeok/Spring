package com.spring.example.annotation.pathvariable.controller;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/* @ResponseBody : 메소드에서 리턴되는 값은 View를 통해 출력되지 않고, Http Response Body에 직접 쓰여지게 된다.
 * @GetMapping : Http Get Request를 매핑한다.
 * @PostMapping : Http Post Request를 매핑한다.
 * */

@Controller
public class MyController
{

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String hello(@PathVariable(value = "name") String getName)
	{
		return "URL parameter <br> " + "name = " + getName;
	}

	@RequestMapping("/requestMapping/{name}/{age}/address/{city}/{country}")
	@ResponseBody
	public String handler(@PathVariable Map<String, String> params) 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("URL parameters - <br>");
		
		for (Entry<String, String> entry : params.entrySet()) 
		{
			builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");
		}
		
		return builder.toString();
	}
}