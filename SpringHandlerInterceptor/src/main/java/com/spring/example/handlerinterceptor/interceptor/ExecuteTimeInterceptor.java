package com.spring.example.handlerinterceptor.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter
{
	private String startTime;
	private String endTime;
	private long executeTime;
	
	private	Calendar calendar = Calendar.getInstance();
    private java.util.Date date = calendar.getTime();

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception
	{
		startTime = (new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss").format(date));
		request.setAttribute("startTime", startTime);
		
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{
		endTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

		System.out.println("start time : " + startTime);
		System.out.println("end time : " + endTime);
		
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
