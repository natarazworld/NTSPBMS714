package com.nt.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nt.model.UserDetails;
import com.nt.repository.IUserDetailsRepo;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDetailsRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder  encoder;

	@Override
	public String register(UserDetails details) {
		details.setPwd(encoder.encode(details.getPwd()));
		return  userRepo.save(details).getUnid()+" UserId is registered";
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
