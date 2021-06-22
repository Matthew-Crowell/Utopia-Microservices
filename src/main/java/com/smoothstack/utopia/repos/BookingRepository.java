package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for accessing Booking data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	/**
	 * This method retrieves all active bookings from the database.
	 *
	 * @return the list of all currently active bookings in the database
	 */
	@Query("SELECT booking FROM Booking booking WHERE booking.isActive = TRUE")
	List<Booking> findActiveBookings();

	/**
	 * This method returns a specified booking identified in the database by its confirmation code.
	 *
	 * @param confirmationCode the confirmation code for the desired booking
	 * @return the specified booking as found in the database
	 */
	@Query("SELECT booking FROM Booking booking WHERE booking.confirmationCode = ?1")
	Booking findBookingByConfirmationCode(String confirmationCode);
}
