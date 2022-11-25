package helper;

public class StringUtils {
	public static String toCapitalize(String str) {
		if(str.length() <= 0) return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
