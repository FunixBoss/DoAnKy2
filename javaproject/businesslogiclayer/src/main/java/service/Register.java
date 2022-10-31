package service;

import java.awt.Color;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import helper.regexPattern;

public class Register {
	private static JTextField email;
	private static JTextField password;
	private static JTextField username;
	public static boolean isEmpty(JTextField field, StringBuilder sb, String msg) {
		boolean ok = true;
		if (field.getText().equals("")) {
			sb.append(msg).append("\n");
			field.setBackground(Color.red);
			ok = false;
		} else {
			ok = true;
			field.setBackground(Color.white);
		}
		return ok;
	}
	public static boolean checkPasswordConfirm(JTextField password,JTextField PasswordConfirm,StringBuilder sb) {
		if(password.getText().equals(PasswordConfirm.getText())) {
			return true;
		}else {
			sb.append("Vui Lòng Nhập Chính xác Mật Khẩu").append("\n");
			return false;
		}
	}
	

}
