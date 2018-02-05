package com.spring.example.fileupload.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.fileupload.service.SingleFileUploadModelAttributeService;
import com.spring.example.fileupload.vo.SingleFileUploadVO;

/* 파일 업로드 방법
 * 1. VO 객체를 이용해서  @ModelAttribute를 통해 받을 수 있다.
 * 2. MultipartHttpServletRequest를 통해 Request요청을 통쨰로 받은 후 거기서 File을 빼서 처리할 수 있다.
 * 3. @RequestParam을 통해 MultipartFile을 바로 받을 수도있다
 * */

@Controller
public class SingleFileModelAttributeUploadContoller 
{
	@Autowired
	private SingleFileUploadModelAttributeService singFileUploadModelAttributeService;
	
	@RequestMapping("singleFileModelAttributeUploadForm.do")
	public ModelAndView singleFileModelAttributeUploadForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("SingleFileUpload");
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("singleFileModelAttributeUpload.do")
	public String singleFileModelAttributeUpload(@ModelAttribute SingleFileUploadVO singleFileUploadVO, HttpSession httpSession) throws IOException
	{
		singFileUploadModelAttributeService.saveSingleFileUpload(singleFileUploadVO, httpSession);
		
		return "Single File ModelAttribute Upload Finish";
	}
}
