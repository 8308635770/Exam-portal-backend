package com.exam.examserver.helper;

public class UserAlreadyExistsException extends Exception {
	
	public UserAlreadyExistsException() {
		super("User with this username is already present !! try with another username");
	}
	
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}

}
