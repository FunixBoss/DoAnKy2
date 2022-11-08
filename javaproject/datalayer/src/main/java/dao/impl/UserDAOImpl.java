package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDAO;
import database.CallableStatementUtils;
import database.ConnectDBFromProperties;
import entity.Bookmark;
import entity.History;
import entity.User;
import entity.Vocabulary;

public class UserDAOImpl implements UserDAO {
	// fields
	private List<User> list;

	// constructors
	public UserDAOImpl(Integer level) {
		if (list == null) {
			list = getList(level);
		}
	}

	public UserDAOImpl() {
		if (list == null) {
			list = selectAll();
		}
	}

	public List<User> getList(int level) {
		List<User> list = new ArrayList<>();
		Connection con = null;
		CallableStatement cs = null;
		try {
			con = ConnectDBFromProperties.getConnectionFromClassPath();
			cs = con.prepareCall("{call selUserByLevel(?)}");
			cs.setInt(1, level);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {
				Integer user_id = rs.getInt(1);
				String email = rs.getString(2);
				String fullname = rs.getString(3);
				String phoneNumber = rs.getString(4);
				LocalDate dob = null;
				if (rs.getDate(5) != null) {
					dob = LocalDate.parse(rs.getDate(5).toString(), DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
				}
				Integer user_level = rs.getInt(6);
				LocalDate createdAt = LocalDate.parse(rs.getDate(7).toString(),
						DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
				LocalDate updatedAt = LocalDate.parse(rs.getDate(8).toString(),
						DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
				list.add(new User(user_id, email, null, user_level, fullname, phoneNumber, dob, createdAt, updatedAt));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					cs.close();
				}
			} catch (Exception e2) {
				// e2.printStackTrace();
				System.out.println("Get list " + (level == 1 ? "Admin" : "User") + "Failed");
			}
		}

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

				// Can be null
				// String fullname = null;
				String fullname = rs.getString(3);

				// String phoneNumber = null;
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
			// e.printStackTrace();
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

		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selAllUser}");
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String email = rs.getString(2);

				// Can be null
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
			// e.printStackTrace();
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
		if (!checkExistEmail(user.getEmail())) {
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			Integer result = 0;
			try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
					var cs = con.prepareCall("{call insertUser(?, ?, ?, ?, ?, ?)}");) {
				// must be validate before insert
				cs.setString(1, user.getEmail());
				cs.setString(2, hashed);
				cs.setInt(3, user.getLevel());

				// can be null
				cs.setString(4, user.getFullname());
				if (user.getDateOfBirth() != null) {
					cs.setDate(5, Date.valueOf(user.getDateOfBirth()));
				} else {
					cs.setDate(5, null);
				}
				cs.setString(6, user.getPhoneNumber());
				result = cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("email da ton tai asd ");
			}
			return result;
		} else {
			JOptionPane.showMessageDialog(null, "Tên Đăng Nhập Đã tồn Taij");
		}
		return 0;
	}

	public boolean checkExistEmail(String email) {
		boolean result = false;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selUserIfExist(?)}");) {
			cs.setString(1, email);
			var rs = cs.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("vui long kiem tra lai du lieu");
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
		return BCrypt.hashpw(acc, BCrypt.gensalt());
	}
	public static int getIdFromDbByAccount(String acc) {
		int result = -1;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				PreparedStatement stmt = con.prepareStatement("SELECT ID FROM [USER] where EMAIL= ?");) {
			stmt.setString(1, acc);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * @return 0 for update private info failed
	 * @return 1 or 2 for update private info successfully
	 */
	public static int getLevelFromUser(User u) {
		int result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selLevelByUserEmail(?)}");) {
			cs.setString(1, u.getEmail());
			var rs = cs.executeQuery();
			if (rs.next()) {
				Integer check = rs.getInt(1);
				return check;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Select level By User Email Failed");
		}
		return 0;
	}

	public static boolean loginDb(User u) {
		try {
			if (BCrypt.checkpw(u.getPassword(), getPassFromDbByAccount(u.getEmail()))) {
				u.setLevel(getLevelFromUser(u));
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Tài Khoản Hoặc Mật Khẩu Không Chính Xác !");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Đăng Nhập Thất Bại Vui Lòng Kiểm Tra Lại Dữ liệu!");
		}
		return false;
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
			
			if(user.getFullname() != null) {
				cs.setString(2, user.getFullname());
			} else {
				cs.setNull(2, Types.NVARCHAR);
			}
			
			if(user.getDateOfBirth() != null) {
				cs.setDate(3, Date.valueOf(user.getDateOfBirth()));
			} else {
				cs.setNull(3, Types.DATE);
			}
			
			if(user.getPhoneNumber() != null) {
				cs.setString(4, user.getPhoneNumber());
			} else {
				cs.setNull(3, Types.NVARCHAR);
			}
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
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call updatePasswordInfoUser(?, ?)}");) {
			cs.setInt(1, user.getId());
			cs.setString(2, hashed);
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update User Password Failed");
		}
		return result;
	}
	public static void main(String[] args) {
		User user = (new User("hung23@gmail.com","Aa@123456",2));
		user.setId(1012);
		new UserDAOImpl().updatePassword(user);
		System.out.println(BCrypt.checkpw("Aa@123456", getPassFromDbByAccount("hung23@gmail.com")));
		System.out.println(getPassFromDbByAccount("hung23@gmail.com"));
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
			// e.printStackTrace();
			System.out.println("Delete a user failed!");
		}
		return result;
	}

	@Override
	public History selectHistoryByUserId(Integer userId) {
		History hst = null;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selHistoryByUserId(?)}");) {
			cs.setInt(1, userId);
			var rs = cs.executeQuery();
			if (rs.next()) {
				Integer bmId = rs.getInt(1);
				Integer vocabId = rs.getInt(2);
				Integer userIdRs = rs.getInt(3);
				hst = new History(bmId, vocabId, userIdRs);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Select History By User Id failed");
		}
		return hst;
	}

	@Override
	public Bookmark selectBookmarkByUserId(Integer userId) {
		Bookmark bm = null;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selBookmarkByUserId(?)}");) {
			cs.setInt(1, userId);
			var rs = cs.executeQuery();
			if (rs.next()) {
				Integer bmId = rs.getInt(1);
				Integer vocabId = rs.getInt(2);
				Integer userIdRs = rs.getInt(3);
				bm = new Bookmark(bmId, vocabId, userIdRs);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Select Bookmark By User Id failed");
		}
		return bm;
	}

	@Override
	public List<User> selectByPages(int pageNumber, int rowOfPages) {
		List<User> list = new ArrayList<>();

		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = CallableStatementUtils.createCS(con, "{call selUserByPages(?, ?)}", pageNumber, rowOfPages);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String email = rs.getString(2);

				// Can be null
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
			e.printStackTrace();
			System.out.println("Select User By Pages Failed");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	public Integer countNumberOfUser() {
		int count = 0;

		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countUser}");
				var rs = cs.executeQuery();) {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<User> selectAdminByPages(int pageNumber, int rowOfPages) {
		List<User> list = new ArrayList<>();

		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = CallableStatementUtils.createCS(con, "{call selAdminByPages(?, ?)}", pageNumber, rowOfPages);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String email = rs.getString(2);

				// Can be null
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
			e.printStackTrace();
			System.out.println("Select User By Pages Failed");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	public Integer countNumberOfAdmin() {
		int count = 0;

		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countAdmin}");
				var rs = cs.executeQuery();) {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public Integer selectIdByUserEmail(String email) {
		Integer id = null;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selIdByUserEmail(?)}");) {
			cs.setString(1,email );
			var rs = cs.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			 e.printStackTrace();
			System.err.println("Select id By User email failed");
		}
		return id;
	}

//	public static void main(String[] args) {
////		System.out.println(new UserDAOImpl().selectIdByUserEmail("hung23n@gmail.com"));
//	}

	
}