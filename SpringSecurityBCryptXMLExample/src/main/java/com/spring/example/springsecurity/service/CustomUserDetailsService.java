package com.spring.example.springsecurity.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomUserDetailsService extends JdbcDaoImpl implements UserDetailsService {
	@Override
	public void setUsersByUsernameQuery(String usersByUsernameQueryString) {
		super.setUsersByUsernameQuery(usersByUsernameQueryString);
	}

	@Override
	public void setAuthoritiesByUsernameQuery(String queryString) {
		super.setAuthoritiesByUsernameQuery(queryString);
	}

	@Override
	public List<UserDetails> loadUsersByUsername(String username) 
	{
		return getJdbcTemplate().query(super.getUsersByUsernameQuery(), new String[] { username },
				new RowMapper<UserDetails>() 
				{
					public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						String username = rs.getString("username");
						String password = rs.getString("password");
						boolean enabled = rs.getBoolean("enabled");
						boolean accountNonExpired = rs.getBoolean("accountNonExpired");
						boolean credentialsNonExpired = rs.getBoolean("credentialsNonExpired");
						boolean accountNonLocked = rs.getBoolean("accountNonLocked");

						return new User(username, password, enabled, accountNonExpired, credentialsNonExpired,
								accountNonLocked, AuthorityUtils.NO_AUTHORITIES);
					}
				});
	}
}
