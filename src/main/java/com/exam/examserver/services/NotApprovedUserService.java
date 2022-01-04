package com.exam.examserver.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examserver.entity.NotApprovedUsers;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;

@Service
public interface NotApprovedUserService {
	
    public NotApprovedUsers createNotApprovedUser(NotApprovedUsers user) throws Exception;
    
    public List<NotApprovedUsers> getAllNotApprovedUsers();
    
    public void deleteNotApprovedUser(Long id);


}
