package com.smoothstack.utopia.controllers;


import com.smoothstack.utopia.entities.Flight;
import com.smoothstack.utopia.services.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Class to handle REST requests related to Flights.
 *
 * @author matthew.crowell
 */
@RestController
public class FlightController {

	private final FlightService flightService;

	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	/**
	 * Provide access to all flights.
	 *
	 * @return List<Flight> all flights in database
	 */
	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public List<Flight> displayFlights() {
		return flightService.getFlights();
	}

	/**
	 * Provide access to a single Flight by id number.
	 *
	 * @param id int this.id
	 * @return Flight with specified id
	 */
	@RequestMapping(value = "/flights/id/{id}", method = RequestMethod.GET)
	public Flight displayFlightById(@PathVariable("id") int id) {
		return flightService.getFlightById(id);
	}

	/**
	 * Provide access to Flights by departure date.
	 *
	 * @param date Date of departure
	 * @return List<Flight> list of flights departing on date
	 */
	@RequestMapping(value = "/flights/date/{date}", method = RequestMethod.GET)
	public List<Flight> displayFlightById(@PathVariable("date") @DateTimeFormat(pattern = "MM-dd-yyyy") Date date) {
		return flightService.getFlightsByDate(date);
	}

	/**
	 * Add a Flight.
	 *
	 * @param flight Flight to add
	 * @return Flight added or null
	 */
	@RequestMapping(value = "/flights", method = RequestMethod.POST)
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}


	/**
	 * Update a Flight.
	 *
	 * @param flight Flight with updated details
	 * @return Flight record in database after update
	 */
	@RequestMapping(value = "/flights", method = RequestMethod.PUT)
	public Flight updateFlightById(@RequestBody Flight flight) {
		return flightService.updateFlight(flight);
	}

	/**
	 * Delete a Flight.
	 *
	 * @param id int this.id
	 * @return Flight deleted
	 */
	@RequestMapping(value = "/flights/id/{id}", method = RequestMethod.DELETE)
	public Flight deleteFlight(@PathVariable("id") int id) {
		return flightService.deleteFlight(id);
	}
}
