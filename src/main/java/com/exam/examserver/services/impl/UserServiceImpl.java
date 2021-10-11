package com.exam.examserver.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.helper.UserAlreadyExistsException;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import com.exam.examserver.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	 private UserRepository userRepo;
	 
	@Autowired
	 private RoleRepository roleRepo;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=this.userRepo.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User alreay exists");
			throw new UserAlreadyExistsException();
		}
		
		for(UserRole userRole:userRoles) {
			roleRepo.save(userRole.getRole());
		}
		
		user.getUserRoles().addAll(userRoles);
		
		 local=userRepo.save(user);
		
		return local;
	}

	@Override
	public User getUser(String username) throws Exception {
		User user= userRepo.findByUsername(username);
		if(user==null) {
			throw new Exception("User not found..");
		}
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		 this.userRepo.deleteById(id);;
	}





}
