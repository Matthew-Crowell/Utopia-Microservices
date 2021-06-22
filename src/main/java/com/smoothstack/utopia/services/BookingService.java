package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Booking;

import java.util.List;

/**
 * This class defines the interface for working with the booking service.
 *
 * @author matthew.crowell
 */
public interface BookingService {
	/**
	 * This method adds a new booking to the database.
	 *
	 * @param booking an object containing the booking data
	 * @return the booking as saved in the database
	 */
	Booking addBooking(Booking booking);

	/**
	 * This method returns a list of all bookings from the database.
	 *
	 * @return the list of all bookings found in the database
	 */
	List<Booking> getBookings();

	/**
	 * This method returns a list of all active bookings from the database.
	 *
	 * @return the list of all active bookings found in the database
	 */
	List<Booking> getActiveBookings();

	/**
	 * This method returns a specified booking identified in the database by its
	 * confirmation code.
	 *
	 * @param confirmationCode the confirmation code of the desired booking
	 * @return the target booking as found in the database
	 */
	Booking getBookingByConfirmationCode(String confirmationCode);

	/**
	 * This method updates the specified booking data in the database.
	 *
	 * @param booking a new object with the desired booking data
	 * @return the modified booking as saved in the database
	 */
	Booking updateBooking(Booking booking);

	/**
	 * This method removes a booking from the database by its id.
	 *
	 * @param id the id of the booking to be removed from the database
	 * @return the booking that was removed from the database
	 */
	Booking deleteBooking(int id);

}
