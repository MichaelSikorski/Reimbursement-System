package com.revature.model;

public class Login {

	private String email;
	private String type;
	
	public Login(String email, String type) {
		this.email = email;
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
