package com.exam.examserver.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.NotApprovedUsers;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.helper.UserAlreadyExistsException;
import com.exam.examserver.repository.NotApprovedUserRepository;
import com.exam.examserver.services.NotApprovedUserService;

@Service
public class NotApprovedUserServiceImpl implements NotApprovedUserService{
	
	@Autowired
	private NotApprovedUserRepository notApprovedUserRepo;

	@Override
	public NotApprovedUsers createNotApprovedUser(NotApprovedUsers user) throws Exception {
		NotApprovedUsers local=this.notApprovedUserRepo.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User alreay exists");
			throw new UserAlreadyExistsException();
		}
		
	    local=notApprovedUserRepo.save(user);
		return local;
	}

	@Override
	public List<NotApprovedUsers> getAllNotApprovedUsers() {
		// TODO Auto-generated method stub
		return notApprovedUserRepo.findAll();
	}

	@Override
	public void deleteNotApprovedUser(Long id) {
		System.out.println("id"+id);
		this.notApprovedUserRepo.deleteById(id);
	}
	


}
