package com.smoothstack.utopia.controllers;

import com.smoothstack.utopia.entities.Airport;
import com.smoothstack.utopia.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class handles incoming requests for the airport service.
 *
 * @author matthew.crowell
 */
@RestController
public class AirportController {

	@Autowired
	private AirportService airportService;

	/**
	 * This method uses the airport service to add an airport to the database.
	 *
	 * @param airport a new airport object with the desired iata code and city data
	 * @return the new airport as saved in the database
	 */
	@RequestMapping(value = "/airports", method = RequestMethod.POST)
	public Airport addAirport(@RequestBody Airport airport) {
		return airportService.addAirport(airport);
	}

	/**
	 * Returns a list of all airports.
	 *
	 * @return List<Airport> list of all airports
	 */
	@GetMapping(value = "/airports")
	public List<Airport> displayAirports() {
		return airportService.getAirports();
	}

	/**
	 * This method returns the data for the specified airport as identified by
	 * its iata code.
	 *
	 * @param iata the unique iata code of the target airport
	 * @return the specified airport as found in the database
	 */
	@RequestMapping(value = "/airports/id/{id}", method = RequestMethod.GET)
	public Airport displayAirportById(@PathVariable("id") String iata) {
		return airportService.getAirportById(iata);
	}

	/**
	 * This method returns the list of all airports found in the given city.
	 *
	 * @param city the name of the target city
	 * @return the list of all airports in the database that are located in the given city
	 */
	@RequestMapping(value = "/airports/city/{city}", method = RequestMethod.GET)
	public List<Airport> displayAirportsByCity(@PathVariable("city") String city) {
		return airportService.getAirportsByCity(city);
	}

	/**
	 * This method updates the data in the database for the given airport.
	 *
	 * @param airport an airport object with the new data
	 * @return the modified airport as saved in the database
	 */
	@RequestMapping(value = "/airports", method = RequestMethod.PUT)
	public Airport updateAirport(@RequestBody Airport airport) {
		return airportService.updateAirport(airport);
	}

	/**
	 * This method removes an airport identified by its iata code from the database.
	 *
	 * @param iata the unique iata code of the target airport
	 * @return the airport that was removed from the database
	 */
	@RequestMapping(value = "/airports/id/{id}", method = RequestMethod.DELETE)
	public Airport deleteAirport(@PathVariable("id") String iata) {
		return airportService.deleteAirportById(iata);
	}
}
