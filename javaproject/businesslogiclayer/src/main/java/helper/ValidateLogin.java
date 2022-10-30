package helper;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import service.Login;
import service.Register;

public class ValidateLogin {
	public static boolean checkAll(JTextField textFieldEmail,JTextField textFieldPassword,StringBuilder s) {
		boolean ok = true;
		boolean checkPassword= Login.checkRegex(regexPattern.PASSWORD, textFieldPassword, s);
		boolean checkEmail=Login.checkRegex(regexPattern.EMAIL, textFieldEmail, s);
		if (!(checkPassword && checkEmail)) {
			return false;
		}
		return ok;
	}
}
