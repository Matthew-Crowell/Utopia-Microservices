package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing UserRole data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	/**
	 * Get number of user roles saved in database.
	 *
	 * @return int number of user roles
	 */
	@Query("SELECT COUNT(a) FROM UserRole a")
	int findRoleCount();
}
