package com.spring.example.fileupload.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.fileupload.service.MultipleFileUploadModelAttributeService;
import com.spring.example.fileupload.vo.MultipleFileUploadVO;

@Controller
public class MultipleFileModelAttributeController 
{
	@Autowired
	private MultipleFileUploadModelAttributeService multipleFileUploadModelAttributeService;
	
	@RequestMapping("multipleFileModelAttributeUploadForm.do")
	public ModelAndView singleFileModelAttributeUploadForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("MultipleFileUpload");
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("multipleFileModelAttributeUpload.do")
	public String singleFileModelAttributeUpload(@ModelAttribute MultipleFileUploadVO multipleFileUploadVO, HttpSession httpSession) throws IOException
	{
		multipleFileUploadModelAttributeService.saveMultipleFileUpload(multipleFileUploadVO, httpSession);
		
		return "Multiple File Upload Finish";
	}
}
