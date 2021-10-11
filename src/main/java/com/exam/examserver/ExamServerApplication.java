package com.exam.examserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.services.UserService;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		userService.deleteUser(21L);
//		
		System.out.println("Your Application is started");
//		User user=new User();
//		
//		user.setFirstName("Shivam");
//		user.setLastName("Tapade");
//		user.setUsername("admin");
//		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
//		user.setEmail("srt@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1=new Role();
//		role1.setRoleId(1L);
//		role1.setRoleName("Admin");
//
//		
//		Set<UserRole>userRoles=new HashSet<UserRole>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);	
//		userRoles.add(userRole);
//		
//		User user1=this.userService.createUser(user, userRoles);
//		System.out.println(user.toString());
				
		
	}

}
