package com.spring.example.modelattribute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.modelattribute.vo.UserVO;

@Controller
@SessionAttributes("userVo")
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
	
	/* @SessionAttributes("name") 설정시, Model에 "name"이라는 이름으로 저장되는 데이터가 있다면 그 데이터를 세션(HttpSession)에도 자동으로 저장한다
	 * @Controller
	   @SessionAttributes("board") // 2. Model에 board로 저장된 객체가 있다면, 그 데이터를 세션에 자동으로 저장한다.
	   public class BoardController {
		 
		//게시판 상세 보기
	    @RequestMapping(value = "/getBoard.do")
	    public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
	        // boardDAO.getBoard(vo)의 리턴타입은 BoardVO 타입이라 가정한다.
	        model.addAttribute("board", boardDAO.getBoard(vo));  // 1. 검색 결과를 Model에 board라는 이름으로 저장한다.
	        return "getBoard.jsp";
	    }
	 
	    // 게시판 글 수정
	    @RequestMapping(value = "/updateBoard.do")
	    public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) { 
	    // 3. board 이름으로 저장된 객체가 있는지 검사한다 (SessionAttribute -> ModelAttribute 순서다). 
	    // 4. 객체가 있다면 매개변수에 할당한다. 
	    // 5. 이 후 사용자가 입력한 파라미터 값을 vo 객체에 할당한다.(이때 사용자가 입력한 수정 정보만 새롭게 할당한다.
	        System.out.println("번호 : " + vo.getSeq());
	        System.out.println("제목 : " + vo.getTitle());
	        System.out.println("작성자 : " + vo.getWriter());
	        System.out.println("내용 : " + vo.getContent());
	        System.out.println("등록일 : " + vo.getRegDate());
	        System.out.println("조회수 : " + vo.getCnt()); 
	        boardDAO.updateBoard(vo);
	        return "getBoardList.do";
	    }
	}
	 * */
	@ResponseBody
	@RequestMapping("updateUserVo.do")
	public String updateUserVo(@RequestParam("userName") String username, @ModelAttribute("userVo") UserVO user )
	{
		return user.getUserName() + " " + user.getFruit() + " " + user.getAddress();
	}
	
	@ResponseBody
	@RequestMapping("sessionDel.do")
	public String updateUserVo(SessionStatus session, @ModelAttribute("userVo") UserVO user )
	{
		// "HTTP Status 500 - Session attribute 'userVo' required - not found in session" 에러 발생
		session.setComplete(); // 세션에서 삭제
		
		return user.getUserName() + " " + user.getFruit() + " " + user.getAddress();
	}

}
