package com.exam.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.entity.NotApprovedUsers;
import com.exam.examserver.entity.User;
import com.exam.examserver.services.NotApprovedUserService;

@RestController
@RequestMapping("/not-approved")
@CrossOrigin("*")
public class NotApprovedUsersController {
	
	@Autowired
	private NotApprovedUserService notApprovedUserService;
	
	@PostMapping("/")
	public ResponseEntity<?>createUserForApproval(@RequestBody NotApprovedUsers user) throws Exception{
		return ResponseEntity.ok(notApprovedUserService.createNotApprovedUser(user));
		
	}
	
	@GetMapping("/get-all-requested-users")
	public ResponseEntity<?>getAllNotApprovedUsers(){
		return ResponseEntity.ok(notApprovedUserService.getAllNotApprovedUsers());
	}
	
	@DeleteMapping("/{id}")
	public void deleteRequestedUser(@PathVariable("id") Long id) {
		notApprovedUserService.deleteNotApprovedUser(id);
	}

}
