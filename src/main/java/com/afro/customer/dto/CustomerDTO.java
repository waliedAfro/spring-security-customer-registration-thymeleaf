package com.afro.customer.dto;

public class CustomerDTO {
	
	// Data Transfer Object to transfer data between client and server
	private String firstName;
	private String surname;
	private String mobile;
	private String password;
	private String gender;
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getSurname() {
		return surname;
	}
	public String getMobile() {
		return mobile;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

	

}
