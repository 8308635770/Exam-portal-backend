package com.exam.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entity.NotApprovedUsers;
import com.exam.examserver.entity.User;

@Repository
public interface NotApprovedUserRepository extends JpaRepository<NotApprovedUsers,Long> {
	
	
    public NotApprovedUsers findByUsername(String username);
    
    public void deleteById(Long id);



}
