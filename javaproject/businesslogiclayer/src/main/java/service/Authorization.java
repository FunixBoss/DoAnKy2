package service;

import entity.User;

public  class Authorization {
	private String email;
	private String fullName;
	private int loggedrole;
	private String birthDay;
	private String phoneNumber;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getLoggedrole() {
		return loggedrole;
	}
	public void setLoggedrole(int loggedrole) {
		this.loggedrole = loggedrole;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Authorization(String email, String fullName, int loggedrole, String birthDay, String phoneNumber) {
		this.email = email;
		this.fullName = fullName;
		this.loggedrole = loggedrole;
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
	}
	public Authorization(String email, String fullName, int loggedrole) {
		this.email = email;
		this.fullName = fullName;
		this.loggedrole = loggedrole;
	}
	@Override
	public String toString() {
		return "Authorization [email=" + email + ", fullName=" + fullName + ", loggedrole=" + loggedrole + ", birthDay="
				+ birthDay + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
