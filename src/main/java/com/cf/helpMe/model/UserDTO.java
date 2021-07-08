package com.cf.helpMe.model;

import lombok.Data;

@Data
public class UserDTO {

	private String email;
	private String password;
	private String username;
	private String country;
	private String school;
	private String level;
}
