package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.model.UserDetails;

public interface IUserService extends UserDetailsService {
	public    String register(UserDetails details);
}
