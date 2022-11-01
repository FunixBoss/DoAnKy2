package helper;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import service.Login;
import service.Register;

public class ValidateLogin {
	public static boolean  checkEmail;
	public static boolean  checkPassword;
	public static boolean checkAll(JTextField textFieldEmail,JTextField textFieldPassword,StringBuilder s) {
		checkEmail=Login.checkRegexLogin(regexPattern.EMAIL, textFieldEmail, s,"email");
		checkPassword= Login.checkRegexLogin(regexPattern.PASSWORD, textFieldPassword, s,"Password");
		boolean ok = true;
		if (!(checkPassword && checkEmail)) {
			return false;
		}
		
		return ok;
	}
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
//		boolean checkEmail=Login.checkRegex(regexPattern.EMAIL, "hung@gmail.com",  s);
//		boolean checkPassword= Login.checkRegex(regexPattern.PASSWORD, textFieldPassword, s);

	}
}
