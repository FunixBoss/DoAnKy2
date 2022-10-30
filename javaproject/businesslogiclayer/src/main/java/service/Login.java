package service;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class Login {
	
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
	public static boolean checkRegex(String regex, JTextField message, StringBuilder sb) {
		boolean ok = true;
		
		try {
			isEmpty(message, sb, "vui lòng nhập dữ liệu");
			Pattern patt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			final Pattern matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			return patt.matcher(message.getText()).matches();
		} catch (Exception e) {
			sb.append("Vui Lòng Nhập Chính Xác Tên").append("\n");
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
}
