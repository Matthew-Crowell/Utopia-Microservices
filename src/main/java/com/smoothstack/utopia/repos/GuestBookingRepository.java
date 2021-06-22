package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.GuestBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing GuestBooking data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface GuestBookingRepository extends JpaRepository<GuestBooking, Integer> {
}
