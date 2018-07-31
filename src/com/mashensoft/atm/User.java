package com.mashensoft.atm;

public class User {
	private String username;
	private String password;
	private String name;
	private double banlance;
	public User(String username, String password, String name, double banlance) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.banlance = banlance;
	}
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBanlance() {
		return banlance;
	}
	public void setBanlance(double banlance) {
		this.banlance = banlance;
	}
	
}
