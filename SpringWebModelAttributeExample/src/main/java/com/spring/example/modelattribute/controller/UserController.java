package com.spring.example.modelattribute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.modelattribute.vo.UserVO;

@Controller
public class UserController 
{
	// 메소드에서 객체를 생성한 뒤 "methodModelAttribute" 이름으로 뷰에 전달됨
	@ModelAttribute("methodModelAttribute")
	public UserVO modelUserMethod()
	{
		UserVO userVO = new UserVO();

		userVO.setUserName("method name");
		userVO.setFruit("method fruit");
		userVO.setAddress("method Address");
		
		return userVO;
	}

	// 메소드에서 객체를 생성한 뒤 "parameterModelAttribute" 이름으로 뷰에 전달됨
	@ModelAttribute("parameterModelAttribute") //userInfoPost 메소드  (Line 69)와 이름 중복. userInfoPost 테스트를 통한 값 확인할 것.
	public UserVO modelUserPost()
	{
		UserVO userVO = new UserVO();

		userVO.setUserName("parameter name");
		userVO.setFruit("parameter fruit");
		userVO.setAddress("parameter Address");
		
		return userVO;
	}

	@RequestMapping("/userForm")
	public ModelAndView userForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userForm");
		
		return modelAndView;
	}
	
	/* userInfoGet 메소드 내에서 어떠한 객체도 뷰로 전달하지 않음. 
	 * userInfoGet 메소드에서 userVo는 전달하지 않으므로, 화면상 userVo 데이터가 보이지 않음
	 * methodModelAttribute, parameterModelAttribute는  @ModelAttribute로 생성한 뒤 뷰에 전달했으므로 뷰에서 보임.
	 * */
	@RequestMapping(value = "/userInfoGet", method = RequestMethod.GET)
	public ModelAndView userInfoGet()
	{
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("userInfoGet");
		
		return modelAndView;
	}
	
	/* UserInfoPost 메소드에서 userVo를 전달하여 뷰에서 보임
	 * methodModelAttribute는 위의 @ModelAttribute에서 생성되어 뷰에 전달하므로 뷰에서 보임
	 * parameterModelAttribute는  Controller 내에서 동일한 이름으로 ModelAttribute 생성하고 있으며, RequestMapping에서도 받고 있음.
	 * 뷰 확인 결과, ModelAttribute로 생성한 데이터가 아닌  파라미터로 전달받은 데이터가 출력됨.
	 * */
	@RequestMapping(value = "/userInfoPost", method = RequestMethod.POST)
	public ModelAndView userInfoPost(@ModelAttribute("parameterModelAttribute") UserVO user)
	{
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("userInfoPost");
		modelAndView.addObject("userVo", user);
		
		return modelAndView;
	}
	
}
