package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Flight;

import java.util.Date;
import java.util.List;

/**
 * Interface for Flight service.
 *
 * @author matthew.crowell
 */
public interface FlightService {
	/**
	 * Add a new Flight.
	 *
	 * @param flight Flight new flight
	 * @return Flight created flight
	 */
	Flight addFlight(Flight flight);

	/**
	 * Get all flights.
	 *
	 * @return List<Flight> list of all flights
	 */
	List<Flight> getFlights();

	/**
	 * Get a flight by its flight id.
	 *
	 * @param id int flight id
	 * @return Flight flight with specified id
	 */
	Flight getFlightById(int id);

	/**
	 * Get all flights departing on a specified date.
	 *
	 * @param date Date date of departure
	 * @return List<Flight> list of all flights departing on the given date
	 */
	List<Flight> getFlightsByDate(Date date);

	/**
	 * Update a specified flight.
	 *
	 * @param flight Flight flight to modify
	 * @return Flight flight with updated flight information
	 */
	Flight updateFlight(Flight flight);

	/**
	 * Delete a flight.
	 *
	 * @param id int flight id
	 * @return Flight flight that was deleted from database
	 */
	Flight deleteFlight(int id);
}
