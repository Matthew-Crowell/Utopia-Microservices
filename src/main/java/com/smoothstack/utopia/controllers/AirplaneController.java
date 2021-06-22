package com.smoothstack.utopia.controllers;

import com.smoothstack.utopia.entities.Airplane;
import com.smoothstack.utopia.services.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to handle REST requests related to Airplanes.
 *
 * @author matthew.crowell
 */
@RestController
public class AirplaneController {
	@Autowired
	private AirplaneService airplaneService;

	/**
	 * Add a new airplane.
	 *
	 * @param airplane Airplane new airplane
	 * @return Airplane saved airplane
	 */
	@RequestMapping(value = "/airplanes", method = RequestMethod.POST)
	public Airplane addAirplane(@RequestBody Airplane airplane) {
		return airplaneService.addAirplane(airplane);
	}

	/**
	 * Provide access to a list of all airplanes in the database.
	 *
	 * @return List<Airplane> list of all airplanes
	 */
	@RequestMapping(value = "/airplanes", method = RequestMethod.GET)
	public List<Airplane> displayAirplanes() {
		return airplaneService.getAirplanes();
	}

	/**
	 * This method returns the specified airplane as identified by its unique id.
	 *
	 * @param id the unique database id of the target airplane
	 * @return the specified airplane
	 */
	@RequestMapping(value = "/airplanes/id/{id}", method = RequestMethod.GET)
	public Airplane displayAirplaneById(@PathVariable("id") int id) {
		return airplaneService.getAirplaneById(id);
	}

	/**
	 * Provide access to all airplanes of a specified type.
	 *
	 * @param type int airplane type
	 * @return List<Airplane> list of all airplanes of specified type
	 */
	@RequestMapping(value = "/airplanes/type/{type}", method = RequestMethod.GET)
	public List<Airplane> displayAirplanesByType(@PathVariable("type") int type) {
		return airplaneService.getAirplanesByType(type);
	}

	/**
	 * Update airplane.
	 *
	 * @param airplane Airplane airplane with new specifications
	 * @return Airplane updated airplane
	 */
	@RequestMapping(value = "/airplanes", method = RequestMethod.PUT)
	public Airplane updateAirplane(@RequestBody Airplane airplane) {
		return airplaneService.updateAirplane(airplane);
	}

	/**
	 * Delete airplane.
	 *
	 * @param id int airplane id
	 * @return Airplane airplane deleted from database
	 */
	@RequestMapping(value = "/airplanes/id/{id}", method = RequestMethod.DELETE)
	public Airplane deleteAirplane(@PathVariable("id") int id) {
		return airplaneService.deleteAirplane(id);
	}
}
