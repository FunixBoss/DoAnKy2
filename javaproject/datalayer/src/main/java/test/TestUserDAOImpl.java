package test;

import java.time.LocalDate;
import java.util.List;

import dao.UserDAOImpl;
import entity.User;

public class TestUserDAOImpl {
	public static void main(String[] args) {
		User user = new User("daohoangmy@gmail.com", "123123", 1, null, null, null , null, null);
//		showListUser(); // done
//		System.out.println(selectAUser(3)); // done
		
//		System.out.println(insertAUser(user)); // done
//		System.out.println(updatePrivateInformationUser()); // done
//		System.out.println(updatePasswordUser()); done
		System.out.println(deleteUser(selectAUser(9)));
	}
	
	public static void showListUser() {
		List<User> list = new UserDAOImpl().selectAll();
		list.forEach(user -> System.out.println(user));	
	}
	
	public static User selectAUser(Integer id ) {
		return new UserDAOImpl().select(id);
	}
	
	public static int insertAUser(User user) {
		return new UserDAOImpl().insert(new User());
	}
	
	public static int updatePrivateInformationUser() {
		User user = new User(1, "updated@gmail.com", "123123", 1, "Updated", "0123456789", LocalDate.now(), null, null);
		return new UserDAOImpl().updatePrivateInfoUser(user);
	}
	
	public static int updatePasswordUser() {
		User user = new User(1, "updated@gmail.com", "updatedPassword", 1, "Updated", "0123456789", LocalDate.now(), null, null);
		return new UserDAOImpl().updatePassword(user);
	}
	
	public static int deleteUser(User user) {
		return new UserDAOImpl().delete(user);
	}
}
