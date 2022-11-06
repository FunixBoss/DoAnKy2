package service;

import entity.User;

public class  Authorization {
	public static String email;
	public static String fullName;
	public static int loggedrole;
	public static String birthDay;
	public static String phoneNumber;
	public static void setNull() {
		Authorization.email = null;
		Authorization.fullName = null;
//		Authorization.loggedrole = null;
		Authorization.birthDay = null;
		Authorization.phoneNumber = null;
	}
	public Authorization(String email, String fullName, int loggedrole, String birthDay, String phoneNumber) {
		Authorization.email = email;
		Authorization.fullName = fullName;
		Authorization.loggedrole = 0;
		Authorization.birthDay = birthDay;
		Authorization.phoneNumber = phoneNumber;
	}
	public Authorization(String email, String fullName, int loggedrole) {
		Authorization.email = email;
		Authorization.fullName = fullName;
		Authorization.loggedrole = loggedrole;
	}
	@Override
	public String toString() {
		return "Authorization [email=" + email + ", fullName=" + fullName + ", loggedrole=" + loggedrole + ", birthDay="
				+ birthDay + ", phoneNumber=" + phoneNumber + "]";
	}
	public static void main(String[] args) {
	}
	
}
