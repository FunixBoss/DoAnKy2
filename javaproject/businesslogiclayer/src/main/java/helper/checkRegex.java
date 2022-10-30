package helper;

import java.util.regex.Pattern;

import javax.swing.JTextField;

public class checkRegex {
	public static boolean checkRegex(String regex, JTextField message, StringBuilder sb) {
		boolean ok = true;
		
		try {
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
