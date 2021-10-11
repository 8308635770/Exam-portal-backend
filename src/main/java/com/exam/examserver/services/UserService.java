package com.exam.examserver.services;



import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;


@Service
public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username) throws Exception;

    //delete user by id
    public void deleteUser(Long userId);
}
