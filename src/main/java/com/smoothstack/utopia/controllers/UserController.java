package com.smoothstack.utopia.controllers;

import com.smoothstack.utopia.entities.User;
import com.smoothstack.utopia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to handle REST requests related to Users.
 *
 * @author matthew.crowell
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * This method adds a new user to the database.
	 *
	 * @param user a new user object with the desired user data
	 * @return the new user as saved in the database
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	/**
	 * Provide access to all users.
	 *
	 * @return List<User> list of all users
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> displayUsers() {
		return userService.getUsers();
	}

	/**
	 * Provide access to users matching a partial name.
	 *
	 * @param partialName String portion of a given or family name
	 * @return List<User> list of all users matching partial name
	 */
	@RequestMapping(value = "/users/partialname/{partialName}", method = RequestMethod.GET)
	public List<User> displayUsersByPartialName(@PathVariable String partialName) {
		return userService.getUsersByPartialName(partialName);
	}

	/**
	 * Provide access to users matching a specified given name and family name.
	 *
	 * @param givenName  String user's given name
	 * @param familyName String user's family name
	 * @return List<User> list of all users with specified given and family names
	 */
	@RequestMapping(value = "/users/fullname/{givenName}_{familyName}", method = RequestMethod.GET)
	public List<User> displayUsersByFirstAndLastName(@PathVariable String givenName, @PathVariable String familyName) {
		return userService.getUsersByFullName(givenName, familyName);
	}

	/**
	 * Provide access to users linked to a specified email address.
	 *
	 * @param email String email address
	 * @return List<User> a list of all users linked to the specified email address
	 */
	@RequestMapping(value = "/users/email/{email}", method = RequestMethod.GET)
	public User displayUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	/**
	 * Provide access to all users linked to a specified phone number.
	 *
	 * @param phone String phone number
	 * @return List<User> list of all users linked to specified phone number
	 */
	@RequestMapping(value = "/users/phone/{phone}")
	public User displayUserByPhone(@PathVariable String phone) {
		return userService.getUserByPhone(phone);
	}

	/**
	 * This method updates an existing user in the database.
	 *
	 * @param user a new user object with the updated information
	 * @return the modified user as saved in the database
	 */
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	/**
	 * This method removes a user from the database.
	 *
	 * @param id the unique id of the user to be removed from the database
	 * @return the user that was deleted from the database
	 */
	@RequestMapping(value = "/users/id/{id}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}
}
