package com.smoothstack.utopia.services;


import com.smoothstack.utopia.entities.User;

import java.util.List;

/**
 * This class defines the interface for working with the user service.
 *
 * @author matthew.crowell
 */
public interface UserService {

	/**
	 * Add a user to the database.
	 *
	 * @param user the user to be added to the database
	 * @return the new user as saved in the database
	 */
	User addUser(User user);

	List<User> getUsers();

	/**
	 * Gets user by user id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	User getUserById(long id);

	/**
	 * Gets users by partial name.
	 *
	 * @param givenName the given name
	 * @return the users by partial name
	 */
	List<User> getUsersByPartialName(String givenName);

	/**
	 * Gets users by full name.
	 *
	 * @param givenName  the given name
	 * @param familyName the family name
	 * @return the users by full name
	 */
	List<User> getUsersByFullName(String givenName, String familyName);

	/**
	 * Gets user by email.
	 *
	 * @param email the email
	 * @return the user by email
	 */
	User getUserByEmail(String email);

	/**
	 * Gets user by phone number.
	 *
	 * @param phone the target phone number
	 * @return the user identified by phone number
	 */
	User getUserByPhone(String phone);

	/**
	 * Update user user.
	 *
	 * @param user the user
	 * @return the user
	 */
	User updateUser(User user);

	/**
	 * Delete user by user id.
	 *
	 * @param id the user id
	 * @return the user
	 */
	User deleteUser(long id);
}
