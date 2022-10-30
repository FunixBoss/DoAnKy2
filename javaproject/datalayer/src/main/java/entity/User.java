package entity;

import java.time.LocalDate;

public class User extends Entity {
//   Account information
	private String email;
	private String password;
	private Integer level;

//	private information
	private String fullname;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;

	public User() {
		super();
	}

	// constructor without created and updated time
	public User(String email, String password, Integer level,
			 String fullname, String phoneNumber, LocalDate dateOfBirth,
			 LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.email = email;
		this.password = password;
		this.level = level;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
	}

	public User(Integer id, String email, String password, Integer level,
			String fullname, String phoneNumber, LocalDate dateOfBirth,
			LocalDate createdAt, LocalDate updatedAt) {
		super(id);
		this.email = email;
		this.password = password;
		this.level = level;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", level=" + level + ", fullname="
				+ fullname + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}


}
