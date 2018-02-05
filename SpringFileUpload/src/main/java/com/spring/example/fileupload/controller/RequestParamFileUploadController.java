package com.spring.example.fileupload.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.fileupload.service.RequestParamFileUploadService;

@Controller
public class RequestParamFileUploadController 
{
	@Autowired
	private RequestParamFileUploadService requestParamFileUploadService;
	
	@RequestMapping("requestParamFileUploadForm.do")
	public ModelAndView requestParamFileUploadForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("RequestParamFileUpload");
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("requestParamFileUpload.do")
	public String requestParamFileUpload(@RequestParam("realFile") MultipartFile uploadFile, @RequestParam("fileName")String fileName, HttpSession httpSession) throws IOException
	{
		requestParamFileUploadService.saveFile(uploadFile, fileName, httpSession);
		
		return "RequestParam File Upload Finish";
	}
}


