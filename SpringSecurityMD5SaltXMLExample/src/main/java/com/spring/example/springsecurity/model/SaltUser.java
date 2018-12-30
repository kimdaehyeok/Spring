package com.spring.example.springsecurity.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SaltUser extends User
{
	private String salt;
	
	public SaltUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, String salt) 
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
		this.salt = salt;
	}

	public String getSalt() 
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	
	
}
