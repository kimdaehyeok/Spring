package com.spring.example.springsecurity.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.spring.example.springsecurity.model.SaltUser;


public class CustomUserDetailsService extends JdbcDaoImpl implements UserDetailsService
{
	private String authoritiesByUsernameQuery;

	public void setAuthoritiesByUsernameQuery(String authoritiesByUsernameQuery) {
		this.authoritiesByUsernameQuery = authoritiesByUsernameQuery;
	}

	@Override
	public List<UserDetails> loadUsersByUsername(String username) {
		final List<GrantedAuthority> groupAuthorities = loadGroupAuthorities(username);

		return getJdbcTemplate().query(super.getUsersByUsernameQuery(), new String[] { username },
				new RowMapper<UserDetails>() {
					public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						String username = rs.getString("username");
						String password = rs.getString("password");
						String salt = rs.getString("salt");

						boolean enabled = rs.getBoolean("enabled");
						boolean accountNonExpired = rs.getBoolean("accountNonExpired");
						boolean credentialsNonExpired = rs.getBoolean("credentialsNonExpired");
						boolean accountNonLocked = rs.getBoolean("accountNonLocked");

						return new SaltUser(username, password, enabled, accountNonExpired, credentialsNonExpired,
								accountNonLocked, groupAuthorities, salt);
					}
				});
	}

	public List<GrantedAuthority> loadGroupAuthorities(String username) {
		return getJdbcTemplate().query(authoritiesByUsernameQuery, new String[] { username },
				new RowMapper<GrantedAuthority>() {
					public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
						String roleName = rs.getString("role");

						return new SimpleGrantedAuthority(roleName);
					}
				});
	}

}
