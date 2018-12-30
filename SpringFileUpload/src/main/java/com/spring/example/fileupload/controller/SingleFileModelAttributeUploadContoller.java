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

/* ���� ���ε� ���
 * 1. VO ��ü�� �̿��ؼ�  @ModelAttribute�� ���� ���� �� �ִ�.
 * 2. MultipartHttpServletRequest�� ���� Request��û�� �뤊�� ���� �� �ű⼭ File�� ���� ó���� �� �ִ�.
 * 3. @RequestParam�� ���� MultipartFile�� �ٷ� ���� �����ִ�
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
