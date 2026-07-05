/**
 * 
 */
package com.tutorials.sid.spring.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author kunmu
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	/*
	* This is the basic authentication mechanism using username and password using In-Memory User Details Manager.
	* This uses the UsernamePasswordAuthenticationToken to authenticate the user. If the username and password are correct,
	* it will return the UsernamePasswordAuthenticationToken object with the username, password and authorities.
	* If the username and password are incorrect, it will throw the BadCredentialsException.
	* This has the priority over the basic authentication mechanism -
	* for example, this method will override the userDetailsService authentication.
	* */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		if ("sid".equals(username) && "welcome".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		} else {
			throw new BadCredentialsException("User name or password is incorrect!!!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
