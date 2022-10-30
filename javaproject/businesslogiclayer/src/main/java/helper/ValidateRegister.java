package helper;

import java.awt.Color;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.mindrot.jbcrypt.BCrypt;

import dao.impl.UserDAOImpl;
import entity.User;
import service.Register;

public class ValidateRegister {

	public static boolean checkAll(JTextField textFieldEmail,JTextField textFieldPassword,JTextField textFieldPasswordConfirm,StringBuilder s) {
		boolean ok = true;
		boolean checkPassword= Register.checkRegex(regexPattern.PASSWORD, textFieldPassword, s);
		boolean checkEmail=Register.checkRegex(regexPattern.EMAIL, textFieldEmail, s);
		boolean checkPasswordConfirm= Register.checkRegex(regexPattern.PASSWORD, textFieldPasswordConfirm, s);
		boolean checkPasswordConfirm2= Register.checkPasswordConfirm(textFieldPassword, textFieldPasswordConfirm, s);
		if (!(checkPassword && checkEmail&&checkPasswordConfirm &&checkPasswordConfirm2)) {
			return false;
		}
		return ok;
	}
	

	
	

	public static void main(String[] args) {
//		checkRegex(regexPattern.getName(), "xinchaosd", "sadsad");
		
		
//		CheckRegister x = new CheckRegister("aaa@gmail.com", "Aa@1gasdas", "nguyenphihung123");
//		CheckRegister check = new CheckRegister(email, password, username);
//		User user = new User("hung9","$2a$10$WyzUN8utmomfTn5ITRNxbObKLdbSSCQ1sEJQSlIaKuqSOPnyJ1z7G",1);
//		Integer x2 = new UserDAOImpl().insert(user);
//		System.out.println(x2);
//		User i1 = new UserDAOImpl().select(2005);
//		System.out.println(i1);
//		String hashed = BCrypt.hashpw("Aa123", BCrypt.gensalt());
//		System.out.println(hashed);
//		if (BCrypt.checkpw("XXXewqw", "$2a$10$F3nj/rMAoKJYwrH2Rhl6bOkQ.2G2ulWu0bmFE8UFuidItMH5c9S/2")) {
//			
//			System.out.println("It matches");
////			System.out.println(hashed);
//		}
//		
//		else {
//			System.out.println("It does not match");
//			
//		}
	}
}
