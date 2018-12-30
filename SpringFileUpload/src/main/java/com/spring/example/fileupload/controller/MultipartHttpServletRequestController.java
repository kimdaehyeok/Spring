package com.spring.example.fileupload.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.fileupload.service.MultipartHttpServletRequestService;

@Controller
public class MultipartHttpServletRequestController 
{
	@Autowired
	private MultipartHttpServletRequestService multipartHttpServletRequestService;
	
	@RequestMapping("multipartHttpServletRequestForm.do")
	public ModelAndView multipartHttpServletRequestForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("MultipartHttpServletRequestUpload");
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("multipartHttpServletRequestUpload.do")
	public String test(@RequestParam Map<String, Object> params, MultipartHttpServletRequest request, HttpSession httpSession) throws IOException
	{
		String total = "";
		
		for(String key : params.keySet())
		{
			total = total + key + " " + params.get(key.toString()) + " ";
		}

		Map<String, MultipartFile> fileMap = request.getFileMap();
		
		for(String fileParamName : fileMap.keySet())
		{
			System.out.println("File ParamName : " + fileParamName.toString());
			System.out.println("File Name : " + fileMap.get(fileParamName.toString()).getOriginalFilename());
			
			multipartHttpServletRequestService.saveFile(fileMap.get(fileParamName.toString()), fileMap.get(fileParamName.toString()).getOriginalFilename(), httpSession);
		}
		
		return total;
	}
}
