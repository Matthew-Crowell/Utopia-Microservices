package com.smoothstack.utopia.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class representing User data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private UserRole role;
	private String givenName;
	private String familyName;
	private String username;
	private String email;
	private String phone;
	private String password;

	/**
	 * Get user id.
	 *
	 * @return int user id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set user id.
	 *
	 * @param id int user id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get user's role.
	 *
	 * @return UserRole user's role
	 */
	public UserRole getRole() {
		return role;
	}

	/**
	 * Set user's role.
	 *
	 * @param role UserRole user's role
	 */
	public void setRole(UserRole role) {
		this.role = role;
	}

	/**
	 * Get user's given name.
	 *
	 * @return String given name
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * Set user's given name.
	 *
	 * @param givenName String user's given name
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * Get passenger's family name.
	 *
	 * @return String passenger's family name.
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * Set user's family name.
	 *
	 * @param familyName String user's family name
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * Get user's username.
	 *
	 * @return String user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set user's username.
	 *
	 * @param username String user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get user's email.
	 *
	 * @return String user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set user's email.
	 *
	 * @param email String email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get user's phone number.
	 *
	 * @return String user's phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set user's phone number.
	 *
	 * @param phone String user's phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get user's stored password.
	 *
	 * @return String user's password as stored in database
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set user's password.
	 *
	 * @param password user's password as stored in database
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id && Objects.equals(role, user.role) && Objects.equals(givenName, user.givenName) && Objects.equals(familyName, user.familyName) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, role, givenName, familyName, username, email, phone, password);
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", role=" + role +
				", givenName='" + givenName + '\'' +
				", familyName='" + familyName + '\'' +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
