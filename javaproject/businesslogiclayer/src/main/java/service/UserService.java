package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import dao.impl.BookmarkDAOImpl;
import dao.impl.HistoryDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Bookmark;
import entity.User;
import helper.ErrorMessage;
import helper.RegexPattern;
import helper.Validation;

public class UserService {
	private UserDAOImpl dao;

	public UserService() {
		dao = new UserDAOImpl();
	}

	public boolean add(Map<String, String> data) {
		ErrorMessage.ERROR_MESSAGES = null;
		String email = data.get("email");
		String password = data.get("password");
		String confirmPassword = data.get("confirmPassword");
		String fullname = data.get("fullname");
		String phone = data.get("phone"); // can be null
		String dob = data.get("dob"); // can be null
		Integer level = Integer.parseInt(data.get("level"));
		LocalDate dobFormatted = null;

//		Validate (empty, format, password - confirmPassword, email existed, ...)
		if (email.equals("") || password.equals("") || confirmPassword.equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Ô Email, Mật khẩu và Nhập lại mật khẩu không được để trống!";
			return false;
		} else {
			if (new UserDAOImpl().checkExistEmail(email)) {
				ErrorMessage.ERROR_MESSAGES = "Email đã tồn tại";
				return false;
			} else if (!Validation.checkRegex(RegexPattern.EMAIL, email)) {
				ErrorMessage.ERROR_MESSAGES = "Định dạng Email không đúng!";
				return false;
			} else if (!password.equals(confirmPassword)) {
				ErrorMessage.ERROR_MESSAGES = "Nhập lại mật khẩu không khớp!";
				return false;
			}

		}

		if (!dob.equals("")) {
			try {
				dobFormatted = LocalDate.parse(dob, DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
			} catch (Exception e) {
				ErrorMessage.ERROR_MESSAGES = "Định dạng ngày sinh không đúng! [yyyy-MM-dd]";
				return false;
			}
		} else if (!Validation.checkLength(email, 1, 200)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài email tối đa 200 ký tự";
			return false;
		} else if (!Validation.checkLength(password, 5, 50)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài password ít nhất 5 ký tự và tối đa 50 ký tự";
			return false;
		} else if (!fullname.equals("") && !Validation.checkLength(fullname, 1, 200)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài Họ và tên tối đa 200 ký tự";
			return false;
		} else if (!phone.equals("") && !Validation.checkLength(phone, 1, 11)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài số điện thoại tối đa 11 ký tự";
			return false;
		}

		User user = new User(email, password, level, fullname, phone, dobFormatted);
		dao.insert(user);
		return true;
	}

	public boolean update(Map<String, String> data) {
		ErrorMessage.ERROR_MESSAGES = null;
		Integer userId = Integer.parseInt(data.get("id"));
		String email = data.get("email");
		String password = data.get("password");
		String fullname = data.get("fullname");
		String phone = data.get("phone"); // can be null
		String dob = data.get("dob"); // can be null
		Integer level = Integer.parseInt(data.get("level"));

		User originalUser = dao.select(userId);

		System.out.println(data);
//		System.out.println(originalUser);

		LocalDate dobFormatted = null;
		if (!dob.equals("")) {
			try {
				dobFormatted = LocalDate.parse(dob, DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
			} catch (Exception e) {
				ErrorMessage.ERROR_MESSAGES = "Định dạng ngày sinh không đúng! [yyyy-MM-dd]";
				return false;
			}
		} else if (fullname.equals(originalUser.getFullname()) && phone.equals(originalUser.getPhoneNumber())
				&& dobFormatted.equals(originalUser.getDateOfBirth()) && password.equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Bạn phải thay đổi thông tin mới có thể cập nhật";
			return false;
		} else if (!fullname.equals("") && !Validation.checkLength(fullname, 1, 200)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài Họ và tên tối đa 200 ký tự";
			return false;
		} else if (!phone.equals("") && !Validation.checkLength(phone, 1, 11)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài số điện thoại tối đa 11 ký tự";
			return false;
		}

		User newUser = new User(email, null, level, fullname, phone, dobFormatted);
		newUser.setId(userId);
		if (password.equals("")) {
			dao.updatePrivateInfoUser(newUser);
			return true;
		} else if (!Validation.checkLength(password, 5, 50)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài password ít nhất 5 ký tự và tối đa 50 ký tự";
			return false;

		}

		newUser.setPassword(password);
		dao.updatePrivateInfoUser(newUser);
		dao.updatePassword(newUser);
		return true;

	}


	public boolean delete(User user) {
//		delete history
		new HistoryDAOImpl().delByUserId(user.getId());
		Bookmark bm = new Bookmark();
		bm.getId();
//		delete bookmark
		new BookmarkDAOImpl().delByUserId(user.getId());
//		delete user	
		return dao.delete(user) == 1 ? true : false;
	}
}
