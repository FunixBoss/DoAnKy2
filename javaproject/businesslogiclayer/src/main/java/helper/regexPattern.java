package helper;

public class regexPattern {
	public final static String NAME = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,15}[a-zA-Z0-9]$";
	public final static String EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
	public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	
}
