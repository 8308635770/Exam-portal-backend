package com.exam.examserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.repository.UserRepository;


@Service
public class UserSecurityServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=this.userRepo.findByUsername(username);
		if(user==null) {
			System.out.println("User not found..");
			throw new UsernameNotFoundException("No user found !!");
			
		}
		return user;
	}

}
