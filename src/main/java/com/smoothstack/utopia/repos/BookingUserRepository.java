package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.BookingUser;
import com.smoothstack.utopia.ids.BookingUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing BookingUser data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface BookingUserRepository extends JpaRepository<BookingUser, BookingUserId> {
}
