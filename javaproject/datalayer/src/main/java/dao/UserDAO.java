package dao;

import java.util.List;

import entity.Bookmark;
import entity.History;
import entity.User;
import entity.Vocabulary;

public interface UserDAO extends DAO<User> {
	Integer updatePrivateInfoUser(User user);
	Integer updatePassword(User user);
	boolean checkExistEmail(String email);
	
	History selectHistoryByUserId(Integer userId);
	Bookmark selectBookmarkByUserId(Integer userId);
	
	List<User> selectByPages(int pageNumber, int rowOfPages);
	Integer countNumberOfUser();
	
	List<User> selectAdminByPages(int pageNumber, int rowOfPages);
	Integer countNumberOfAdmin();
}
