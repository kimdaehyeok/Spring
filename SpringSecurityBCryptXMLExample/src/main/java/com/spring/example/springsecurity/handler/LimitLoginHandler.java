package com.spring.example.springsecurity.handler;

import java.util.Date;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.spring.example.springsecurity.dao.UserDetailsDao;
import com.spring.example.springsecurity.model.UserAttemptsEntity;
import com.spring.example.springsecurity.service.CustomUserDetailsService;
/* Authentication�� ������ ��ť��Ƽ���� ���� ���ø����̼ǿ� ������ ������� ���� ������ �����ϴ� ������ �Ѵ�.(��������, ����, ������ü(principal) ��)
 * ������ ��ť��Ƽ�� SecurityContextHolder�� Authentication�� �����Ѵ�.
 * 
 * SecurityContextHolder Ŭ������ getContext() �޼ҵ带 ���� SecurityContext ��ü�� ���� �ް�,
 * SecurityContext ��ü�� getAuthentication() �޼ҵ带 �̿��ؼ� Authentication ��ü�� ���� �� �ֵ�.
 * 
 * Authentication ��ü�� ����� ������ ���� ������� ������ ǥ���ϱ� ���� ���ȴ�.
 * web.xml�� DelegatingFilterProxy�� ������ ��ť��Ƽ�� �����ϴ� FilterChainProxy�� ���� ó���� �����ϸ�, 
 * �� ��ü�� ���� ���͸� ü�� �������� ���� �ִ� SecurityFilterChain�� ó���� �����Ѵ�.(Https�� �����̷�Ʈ, CSRF ���ݹ��, ���� Ÿ�Ӿƿ� �� )
 * 
 * ������ ��ť��Ƽ�� ������ �ʿ��� ��, AuthenticationManager�� �̿��Ѵ�. 
 * Authentication ��ü�� ����Ŭ������ ProviderManagerŬ������ �����ϰ� ������, �� Ŭ������ AuthenticationProvider���� �����Ѵ�.
 * AuthenticationProvider�� authentication()�޼ҵ带 ���� ���� ó���� ��û�� ��, �����̸� Authentication ��ü�� ����, ���и� �ͼ����� �����Ѵ�.
 * AuthenticationProvider�� Dao, Ldap, OpenID ���� AuthenticationProvider ����ü�� ������ �ִ�
 * 
 * DaoAuthenticationProvider�� ����� ������ �о�� ��, UserDeatilsService Ÿ���� ��ü�� �̿��Ѵ�.
 * DaoAuthenticationProvider�� UserDeatilsService�� loadByUsername() �޼���� UserDetails ��ü�� ���Ѵ�.
 * UserDetatils�� getPassword()�� ��ȣ �񱳸� �ѵ�, ��ġ�ϸ� UserDetails ��ü�κ��� Authentication ��ü�� ������ �����Ѵ�.
 * 
 * UserDetailsManager�� ���� ����� ����, �н����� ����, ���� ���� �� �� �ִ�.
 * */

public class LimitLoginHandler extends DaoAuthenticationProvider
{
	private UserDetailsDao userDetailsDao;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		try 
		{
			Authentication auth = super.authenticate(authentication);
			
			// if reach here, means login success, else exception will be thrown
			// reset the user_attempts
			userDetailsDao.resetFailAttempts(authentication.getName());

			return auth;

		} catch (BadCredentialsException e) {
			userDetailsDao.updateFailAttempts(authentication.getName());
			throw e;

		} catch (LockedException e) {

			String error = "";
			
			UserAttemptsEntity userAttempts = userDetailsDao.getUserAttempts(authentication.getName());
			
			System.out.println("********* userAttempts : " + userAttempts);
			if (userAttempts != null) {
				Date lastAttempts = userAttempts.getLastModified();
				error = "User account is locked! <br><br>Username : " + authentication.getName()
						+ "<br>Last Attempts : " + lastAttempts;
			} else {
				error = e.getMessage();
			}

			throw new LockedException(error);
		}
	}

	public UserDetailsDao getUserDetailsDao() 
	{
		return userDetailsDao;
	}

	public void setUserDetailsDao(UserDetailsDao userDetailsDao)
	{
		this.userDetailsDao = userDetailsDao;
	}
}