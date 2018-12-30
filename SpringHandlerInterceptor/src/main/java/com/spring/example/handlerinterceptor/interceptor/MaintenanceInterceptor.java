package com.spring.example.handlerinterceptor.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MaintenanceInterceptor extends HandlerInterceptorAdapter 
{
	private long maintenanceStartTime;
	private long maintenanceEndTime;
	private long currentTime;
	
	private	Calendar calendar = Calendar.getInstance();
    private java.util.Date date = calendar.getTime();
    
    
	public void setMaintenanceStartTime(long maintenanceStartTime) {
		this.maintenanceStartTime = maintenanceStartTime;
	}

	public void setMaintenanceEndTime(long maintenanceEndTime) {
		this.maintenanceEndTime = maintenanceEndTime;
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		currentTime = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
		
		System.out.println("maintenance Start : " + maintenanceStartTime);
		System.out.println("maintenance End : " + maintenanceEndTime);
		System.out.println("Current : " + currentTime);
		
		if(maintenanceStartTime <= currentTime && currentTime <= maintenanceEndTime)
		{
			System.out.println("true");
		}
		
		if(maintenanceStartTime <= currentTime && currentTime <= maintenanceEndTime)
		{
			response.sendRedirect("/SpringHandlerExample/error.do");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
}
