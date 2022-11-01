package dao;

import entity.Bookmark;
import entity.History;
import entity.User;

public interface UserDAO extends DAO<User> {
	Integer updatePrivateInfoUser(User user);
	Integer updatePassword(User user);
	
	History selectHistoryByUserId(Integer userId);
	Bookmark selectBookmarkByUserId(Integer userId);
}
