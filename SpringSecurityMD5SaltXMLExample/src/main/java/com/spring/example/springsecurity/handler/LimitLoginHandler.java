package com.spring.example.springsecurity.handler;

import java.util.Date;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.spring.example.springsecurity.dao.UserDetailsDao;
import com.spring.example.springsecurity.model.SaltUser;
import com.spring.example.springsecurity.model.UserAttemptsEntity;
import com.spring.example.springsecurity.service.CustomUserDetailsService;

/* Authentication은 스프링 시큐리티에서 현재 어플리케이션에 접근한 사용자의 보안 정보를 보관하는 역할을 한다.(인증여부, 권한, 접근주체(principal) 등)
 * 스프링 시큐리티는 SecurityContextHolder에 Authentication을 저장한다.
 * 
 * SecurityContextHolder 클래스에 getContext() 메소드를 통해 SecurityContext 객체를 리턴 받고,
 * SecurityContext 객체의 getAuthentication() 메소드를 이용해서 Authentication 객체를 구할 수 있따.
 * 
 * Authentication 객체는 사용자 인증과 현재 사용자의 정보를 표현하기 위해 사용된다.
 * web.xml에 DelegatingFilterProxy는 스프링 시큐리티가 생성하는 FilterChainProxy에 필터 처리를 위임하며, 
 * 이 객체는 여러 필터를 체인 형식으로 갖고 있는 SecurityFilterChain에 처리를 위임한다.(Https로 리다이렉트, CSRF 공격방어, 세션 타임아웃 등 )
 * 
 * 스프링 시큐리티는 인증이 필요할 때, AuthenticationManager를 이용한다. 
 * Authentication 객체는 구현클래스로 ProviderManager클래스를 제공하고 있으며, 이 클래스는 AuthenticationProvider에게 위임한다.
 * AuthenticationProvider는 Dao, Ldap, OpenID 등의 AuthenticationProvider 구현체를 가지고 있다
 * AuthenticationProvider는 authentication()메소드를 통해 인증 처리를 요청한 뒤, 성공이면 Authentication 객체를 리턴, 실패면 익셉션을 생성한다.
 * 
 * DaoAuthenticationProvider는 사용자 정보를 읽어올 때, UserDeatilsService 타입의 객체를 이용한다.
 * DaoAuthenticationProvider는 UserDeatilsService의 loadByUsername() 메서드로 UserDetails 객체를 구한다.
 * UserDetatils의 getPassword()로 암호 비교를 한뒤, 일치하면 UserDetails 객체로부터 Authentication 객체를 생성해 리턴한다.
 * 
 * UserDetailsManager를 통해 사용자 생성, 패스워드 변경, 삭제 등을 할 수 있다.
 * */
public class LimitLoginHandler extends DaoAuthenticationProvider 
{
	private UserDetailsDao userDetailsDao;
	
	private CustomUserDetailsService customUserDetailsService;
	private Md5PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		try 
		{
			customUserDetailsService = (CustomUserDetailsService) super.getUserDetailsService();
			encoder = (Md5PasswordEncoder) super.getPasswordEncoder();
			
			SaltUser user = (SaltUser) customUserDetailsService.loadUsersByUsername(authentication.getName()).get(0);
			
			String hashPassword = encoder.encodePassword((String) authentication.getCredentials(), user.getSalt());
			
			// get Password : 3e536388e65d8e283437f551ccbb4f2a
			// get Authentication : 123456 (입력 값)
			if(hashPassword.equals(user.getPassword()))
			{
				userDetailsDao.resetFailAttempts(authentication.getName());
				
				return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
			}
			else
			{
				throw new BadCredentialsException("Check your ID or Password");
			}

		} catch (BadCredentialsException e) 
		{
			userDetailsDao.updateFailAttempts(authentication.getName());
			throw e;

		} catch (LockedException e) {

			String error = "";
			
			UserAttemptsEntity userAttempts = userDetailsDao.getUserAttempts(authentication.getName());
			
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