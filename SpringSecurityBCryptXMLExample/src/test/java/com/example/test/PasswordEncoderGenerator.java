package com.example.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator 
{
	public static void main(String[] args) 
	{
		int i = 0;

		while (i < 10) 
		{
			String password = "123456";
			String salt = "salt123";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}
		
//		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
//		String salt = "salt123";
//		String encoded = md5PasswordEncoder.encodePassword("123456",salt);
//		
//		System.out.println(encoded);
	}
}