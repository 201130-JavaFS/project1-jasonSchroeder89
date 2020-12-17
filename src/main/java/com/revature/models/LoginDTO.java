package com.revature.models;

public class LoginDTO {

	private String username;
	private String password;
	private int id;
	private int role;
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		setId(0);
		setRole(0);
	}

	public LoginDTO() {
		super();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}	
}
