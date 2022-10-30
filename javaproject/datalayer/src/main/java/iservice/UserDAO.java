package iservice;

import entity.User;

public interface UserDAO extends DAO<User> {
	Integer updatePrivateInfoUser(User user);
	Integer updatePassword(User user);
}
