package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Airplane;

import java.util.List;

public interface AirplaneService {

	/**
	 * This method adds a new airplane to the database.
	 *
	 * @param airplane a new airplane object with the desired data
	 * @return the new airplane as saved in the database
	 */
	Airplane addAirplane(Airplane airplane);

	/**
	 * This method returns a list of all airplanes found in the database.
	 *
	 * @return the list of all airplanes in the database
	 */
	List<Airplane> getAirplanes();

	/**
	 * This method retrieves a specified airplane from the database by its unique id.
	 *
	 * @param id the unique database id of the airplane
	 * @return the airplane as found in the database
	 */
	Airplane getAirplaneById(int id);

	/**
	 * This method returns a list of all airplanes by airplane type.
	 *
	 * @param type the id of the desired airplane type
	 * @return the list of all airplanes of a given type found in the database
	 */
	List<Airplane> getAirplanesByType(int type);

	/**
	 * This method updates the specified airplane with the data of the airplane
	 * object passed as a parameter.
	 *
	 * @param airplane the airplane object with the new data
	 * @return the modified airplane as saved in the database
	 */
	Airplane updateAirplane(Airplane airplane);

	/**
	 * This method removes an airplane from the database by its unique id.
	 *
	 * @param id the unique id of the target airplane
	 * @return the airplane that was removed from the database
	 */
	Airplane deleteAirplane(int id);
}
