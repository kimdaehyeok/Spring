package com.spring.example.springsecurity.dao;

import org.springframework.stereotype.Component;

import com.spring.example.springsecurity.model.UserAttemptsEntity;

public interface UserDetailsDao 
{
	public void updateFailAttempts(String username);
	public void resetFailAttempts(String username);
	public UserAttemptsEntity getUserAttempts(String username);
}
