package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for accessing User data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Find all users with string in given name or family name field.
	 *
	 * @param partialName String part of given name or family name
	 * @return List<User> list of users matching partial name
	 */
	@Query("SELECT user FROM User user WHERE user.givenName LIKE %?1% OR user.familyName LIKE %?1%")
	List<User> findUsersByPartialName(String partialName);

	/**
	 * Find all users matching a specific given name and family name combination.
	 *
	 * @param givenName  String given name
	 * @param familyName String family name
	 * @return User user matching given name and family name
	 */
	@Query("SELECT user FROM User user WHERE user.givenName = ?1 AND user.familyName = ?2")
	List<User> findUsersByFullName(String givenName, String familyName);

	/**
	 * Find all users linked to a specified email address.
	 *
	 * @param email String email address
	 * @return List<User> list of users linked to email
	 */
	@Query("SELECT user FROM User user WHERE user.email = ?1")
	User findUserByEmail(String email);

	/**
	 * Find all users linked to a specified phone number.
	 *
	 * @param phone String phone number
	 * @return List<User> list of users linked to phone number
	 */
	@Query("SELECT user FROM User user WHERE user.phone = ?1")
	User findUserByPhone(String phone);
}
