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
		User user = new User("abc@gmai.com", "abcxyhz", 3);
		User user2 = new User(1, "abaa@gma", "Aa@12345", 1);
//		showListUser(); // done
//		showListUserByLevel(1);
//		System.out.println(selectAUser(3)); // done
		
//		System.out.println(insertAUser(user)); // done
		System.out.println(updatePasswordUser(user2)); 
//		System.out.println(deleteUser(selectAUser(9)));
//		System.out.println(test.countNumberOfUser());
//		test.selectUserByPages(1, 10).forEach(System.out::println);
//		test.selectAdminByPages(1, 10).forEach(System.out::println);
//		System.out.println(test.countNumberOfUser());

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
		return new UserDAOImpl().insert(user);
	}
	
	public static int updatePasswordUser(User user) {
		return new UserDAOImpl().updatePassword(user);
	}
	
	public static int deleteUser(User user) {
		return new UserDAOImpl().delete(user);
	}

	public List<User> selectUserByPages(int pageNumber, int rowOfPages) {
		return new UserDAOImpl().selectUserByPages(pageNumber, rowOfPages);
	}

	public List<User> selectAdminByPages(int pageNumber, int rowOfPages) {
		return new UserDAOImpl().selectAdminByPages(pageNumber, rowOfPages);
	}
	
	public Integer countNumberOfUser() {
		return  new UserDAOImpl().countNumberOfUser();
	}
}
