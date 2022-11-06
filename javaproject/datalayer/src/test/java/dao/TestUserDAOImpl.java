package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import dao.impl.UserDAOImpl;
import entity.Bookmark;
import entity.History;
import entity.User;

public class TestUserDAOImpl{
	public static void main(String[] args) {
		TestUserDAOImpl test = new TestUserDAOImpl();
//		showListUser(); // done
//		showListUserByLevel(1);
//		System.out.println(selectAUser(3)); // done
		
//		System.out.println(insertAUser(user)); // done
//		System.out.println(updatePrivateInformationUser()); // done
//		System.out.println(updatePasswordUser()); done
//		System.out.println(deleteUser(selectAUser(9)));
//		System.out.println(test.countNumberOfUser());
		test.selectByPages(3, 10).forEach(System.out::println);
	}
	
	public static void showListUser() {
		List<User> list = new UserDAOImpl().selectAll();
		list.forEach(user -> System.out.println(user));	
	}
	
	public static void showListUserByLevel(Integer level) {
		List<User> list = new UserDAOImpl().getList(level);
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

	public List<User> selectByPages(int pageNumber, int rowOfPages) {
		return new UserDAOImpl().selectByPages(pageNumber, rowOfPages);
	}

	public Integer countNumberOfUser() {
		return  new UserDAOImpl().countNumberOfUser();
	}
}
