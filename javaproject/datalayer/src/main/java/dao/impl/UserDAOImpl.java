package dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;
import database.ConnectDBFromProperties;
import entity.User;
import dao.UserDAO;

public class UserDAOImpl implements UserDAO {
//	fields
	private List<User> list;

//	constructors
	public UserDAOImpl() {
		if (list == null) {
			list = selectAll();
		}
	}

	public List<User> getList() {
		return list;
	}

	@Override
	/**
	 * @return null if it doesn't exists
	 */
	public User select(Integer id) {
		User user = null;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selUser(?)}");) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();

			if (rs.next()) {
				Integer user_id = rs.getInt(1);
				String email = rs.getString(2);

//				Can be null
//				String fullname = null;
				String fullname = rs.getString(3);

//				String phoneNumber = null;
				String phoneNumber = rs.getString(4);
				LocalDate dob = null;
				if (rs.getDate(5) != null) {
					dob = LocalDate.parse(rs.getDate(5).toString(), DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
				}
				Integer level = rs.getInt(6);
				LocalDate createdAt = LocalDate.parse(rs.getDate(7).toString(),
						DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
				LocalDate updatedAt = LocalDate.parse(rs.getDate(8).toString(),
						DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));

				user = new User(user_id, email, null, level, fullname, phoneNumber, dob, createdAt, updatedAt);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Get a user failed!");
		}
		return user;
	}

	@Override
	/**
	 * @return null if doesn't have any
	 */
	public List<User> selectAll() {
		List<User> list = new ArrayList<>();
		;

		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selAllUser}");
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String email = rs.getString(2);

//				Can be null
				String fullname = null;
				if (rs.getString(3) != null) {
					fullname = rs.getString(3);
				}

				String phoneNumber = null;
				if (rs.getString(4) != null) {
					phoneNumber = rs.getString(4);
				}
				LocalDate dob = null;
				if (rs.getDate(5) != null) {
					dob = LocalDate.parse(rs.getDate(5).toString(), DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
				}
				Integer level = rs.getInt(6);
				LocalDate createdAt = LocalDate.parse(rs.getDate(7).toString(),
						DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
				LocalDate updatedAt = LocalDate.parse(rs.getDate(8).toString(),
						DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));

				list.add(new User(id, email, null, level, fullname, phoneNumber, dob, createdAt, updatedAt));
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Get list of user failed!");
		}

		return list.isEmpty() ? null : list;
	}

	@Override
	/**
	 * @return 0 for insert failed
	 * @return 1 for insert successfully
	 */
	public Integer insert(User user) {
		Integer result = 0;
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call insertUser(?, ?, ?, ?, ?, ?)}");) {
			// must be validate before insert
			cs.setString(1, user.getEmail());
			cs.setString(2, hashed);
			cs.setInt(3, user.getLevel());

//			can be null
			cs.setString(4, null);
//			cs.setDate(5, Date.valueOf(user.getDateOfBirth()));
			cs.setDate(5, null);
			cs.setString(6, null);

			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Insert User Failed");
		}

		return result;
	}

	@Override
	/*
	 * do not need
	 */
	public Integer update(User user) {
		return 0;
	}

	@Override
	/**
	 * @return 0 for update private info failed
	 * @return 1 for update private info successfully
	 */
	public Integer updatePrivateInfoUser(User user) {
		Integer result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call updatePrivateInfoUser(?, ?, ?, ?)}");) {
			cs.setInt(1, user.getId());
			cs.setString(2, user.getFullname());
			cs.setDate(3, Date.valueOf(user.getDateOfBirth()));
			cs.setDate(3, null);
			cs.setString(4, user.getPhoneNumber());
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update User Failed");
		}
		return result;
	}

	@Override
	/**
	 * @return 0 for update private info failed
	 * @return 1 for update private info successfully
	 */
	public Integer updatePassword(User user) {
		Integer result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call updatePasswordInfoUser(?, ?)}");) {
			cs.setInt(1, user.getId());
			cs.setString(2, user.getPassword());
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update User Password Failed");
		}
		return result;
	}

	@Override
	/**
	 * @return 1 if success
	 * @return 0 if failed
	 */
	public Integer delete(User user) {
		Integer result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call deleteUser(?)}");) {
			cs.setInt(1, user.getId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete a user failed!");
		}
		return result;
	}

	public static String getPassFromDbById(Integer id) {
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				PreparedStatement stmt = con.prepareStatement("SELECT PASSWORD FROM [USER] where id= ?");) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getPassFromDbByAccount(String acc) {
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				PreparedStatement stmt = con.prepareStatement("SELECT PASSWORD FROM [USER] where EMAIL= ?");) {
			stmt.setString(1, acc);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void loginDb(User u) {
		if (BCrypt.checkpw(u.getPassword(),getPassFromDbByAccount(u.getEmail()))) {
			JOptionPane.showMessageDialog(null, "bạn da dang nhap thanh cong");
			
		}else {
			JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Chính Xác Email Và Password");
		}
	}
}
