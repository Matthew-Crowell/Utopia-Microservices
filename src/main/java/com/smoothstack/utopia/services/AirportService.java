package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Airport;

import java.util.List;

public interface AirportService {
	/**
	 * This method adds a new airport object into the database.
	 *
	 * @param airport a new airport object that contains the desired iata and city data
	 * @return the new airport as it is saved in the database
	 */
	Airport addAirport(Airport airport);

	/**
	 * This method retrieves a list of all airports from the database.
	 *
	 * @return a list of all airports as found in the database
	 */
	List<Airport> getAirports();

	/**
	 * This method gets a specified airport by its iata id.
	 *
	 * @param iata the unique iata id of the desired airport
	 * @return the airport with the specified iata id
	 */
	Airport getAirportById(String iata);

	/**
	 * This method retrieves a list of all airports in a specific city.
	 *
	 * @param city the name of the target city
	 * @return the list of all airports within the given city
	 */
	List<Airport> getAirportsByCity(String city);

	/**
	 * This method updates an airport in the database with the details of the airport passed
	 * as a parameter.
	 *
	 * @param airport a new airport with the desired configuration
	 * @return the new airport as stored in the database
	 */
	Airport updateAirport(Airport airport);

	/**
	 * This method deletes the airport with the specified unique iata code from the database.
	 *
	 * @param iata the unique iata id of the targeted airport
	 * @return the airport data that was deleted from the database
	 */
	Airport deleteAirportById(String iata);
}
