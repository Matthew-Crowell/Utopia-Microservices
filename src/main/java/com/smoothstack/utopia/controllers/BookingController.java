package com.smoothstack.utopia.controllers;

import com.smoothstack.utopia.entities.Booking;
import com.smoothstack.utopia.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to handle REST requests related to Bookings.
 *
 * @author matthew.crowell
 */
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	/**
	 * This method adds a booking to the database.
	 *
	 * @param booking a new object with the desired booking data
	 * @return the booking data as stored in the database
	 */
	@RequestMapping(value = "/bookings", method = RequestMethod.POST)
	public Booking addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}

	/**
	 * This method retrieves a list of all bookings from the database.
	 *
	 * @return a list of all bookings
	 */
	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public List<Booking> displayBookings() {
		return bookingService.getBookings();
	}

	/**
	 * This method returns a list of all active bookings in the database.
	 *
	 * @return the list of all currently active bookings found in the database
	 */
	@RequestMapping(value = "/bookings/active", method = RequestMethod.GET)
	public List<Booking> displayActiveBookings() {
		return bookingService.getActiveBookings();
	}

	/**
	 * This method returns a specified booking from the database identified by its
	 * confirmation code.
	 *
	 * @param confirmationCode the confirmation code for the specified booking
	 * @return the booking as found in the database
	 */
	@RequestMapping(value = "/bookings/confirmation/{confirmationCode}", method = RequestMethod.GET)
	public Booking displayBookingByConfirmationCode(@PathVariable("confirmationCode") String confirmationCode) {
		return bookingService.getBookingByConfirmationCode(confirmationCode);
	}

	/**
	 * This method updates an existing booking in the database.
	 *
	 * @param booking a booking object with the updated data
	 * @return the modified booking as saved in the database
	 */
	@RequestMapping(value = "/bookings", method = RequestMethod.PUT)
	public Booking updateBooking(Booking booking) {
		return bookingService.updateBooking(booking);
	}

	/**
	 * This method removes a specified booking from the database.
	 *
	 * @param id the unique id of the target booking
	 * @return the booking that was removed from the database
	 */
	@RequestMapping(value = "/bookings/id/{id}", method = RequestMethod.DELETE)
	public Booking deleteBooking(@PathVariable("id") int id) {
		return bookingService.deleteBooking(id);
	}
}
