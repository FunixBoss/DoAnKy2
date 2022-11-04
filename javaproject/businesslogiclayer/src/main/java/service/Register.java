package service;

import java.awt.Color;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import helper.regexPattern;

public class Register {
	private static JTextField email;
	private static JTextField password;
	private static JTextField username;
	public static boolean isEmpty(JTextField field, StringBuilder sb, String msg) {
		boolean ok = true;
		if (field.getText().equals("")) {
			sb.append(msg).append("\n");
			field.setBorder(new LineBorder(Color.red, 2));
			ok = false;
		} else {
			ok = true;
		}
		return ok;
	}
	public static boolean checkPasswordConfirm(JTextField password,JTextField PasswordConfirm,StringBuilder sb) {
		if(password.getText().equals(PasswordConfirm.getText()) && !PasswordConfirm.getText().equals("") ) {
			PasswordConfirm.setBorder(new LineBorder(Color.GREEN, 2));
			return true;
		}else {
			PasswordConfirm.setBorder(new LineBorder(Color.RED, 2));
			sb.append("Mật Khẩu Không Trùng Khớp").append("\n");
			return false;
		}
	}
	public static boolean checkRegexRegister(String regex, JTextField message, StringBuilder sb,String fieldComponent) {
		boolean ok = true;
		try {
			isEmpty(message, sb, "vui lòng nhập dữ liệu "+ fieldComponent);
			Pattern patt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			final Pattern matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			return patt.matcher(message.getText()).matches();
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
	public static void checkColorText(String regex, JTextField message, StringBuilder sb,String fieldComponent) {
		if(checkRegexRegister(regex, message, sb, fieldComponent)){
			message.setBorder(new LineBorder(Color.GREEN, 2));
		}else {
			message.setBorder(new LineBorder(Color.RED, 2));
		}
	}
	

}
