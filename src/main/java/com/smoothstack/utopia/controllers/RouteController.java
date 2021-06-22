package com.smoothstack.utopia.controllers;

import com.smoothstack.utopia.entities.Route;
import com.smoothstack.utopia.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to handle REST requests related to Routes.
 *
 * @author matthew.crowell
 */
@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;

	/**
	 * Add route to database.
	 *
	 * @param route Route new route to add
	 * @return Route route saved to database
	 */
	@RequestMapping(value = "/routes/new", method = RequestMethod.POST)
	public Route addRoute(@RequestBody Route route) {
		return routeService.addRoute(route);
	}

	/**
	 * Provide access to all routes.
	 *
	 * @return List<Route> list of all routes
	 */
	@RequestMapping(value = "/routes", method = RequestMethod.GET)
	public List<Route> displayRoutes() {
		return routeService.getRoutes();
	}

	/**
	 * This method retrieves a route from the database by its unique id.
	 *
	 * @param id the unique id of the desired route
	 * @return the route returned by the database
	 */
	@RequestMapping(value = "/routes/id/{id}", method = RequestMethod.GET)
	public Route displayRouteById(@PathVariable int id) {
		return routeService.getRouteById(id);
	}

	/**
	 * This method retrieves a list of all routes from the database which
	 * originate at the airport with the specified iata code.
	 *
	 * @param iata the iata code of the desired airport of origination
	 * @return the list of all routes originating at the specified airport
	 */
	@RequestMapping(value = "/routes/origin/iata/{iata}", method = RequestMethod.GET)
	public List<Route> displayRoutesByOriginIATA(@PathVariable String iata) {
		return routeService.getRoutesByOriginIATA(iata);
	}

	/**
	 * This method retrieves a list of all routes from the database which
	 * originate in the specified city.
	 *
	 * @param city the name of the desired city of origin
	 * @return the list of all routes originating from the specified city
	 */
	@RequestMapping(value = "/routes/origin/city/{city}", method = RequestMethod.GET)
	public List<Route> displayRoutesByOriginCity(@PathVariable String city) {
		return routeService.getRoutesByOriginCity(city);
	}

	/**
	 * This method retrieves a list of all routes from the database which
	 * are bound for the airport with the specified iata code.
	 *
	 * @param iata the iata code of the destination airport
	 * @return the list of all routes bound for the specified airport
	 */
	@RequestMapping(value = "/routes/destination/iata/{iata}", method = RequestMethod.GET)
	public List<Route> displayRoutesByDestinationIATA(@PathVariable String iata) {
		return routeService.getRoutesByDestinationIATA(iata);
	}

	/**
	 * This method retrieves a list of all routes from the database which
	 * are bound for the specified city.
	 *
	 * @param city the name of the destination city
	 * @return the list of all routes bound for the specified city
	 */
	@RequestMapping(value = "/routes/destination/city/{city}", method = RequestMethod.GET)
	public List<Route> displayRoutesByDestinationCity(@PathVariable String city) {
		return routeService.getRoutesByDestinationCity(city);
	}

	/**
	 * This method updates a route with the provided details.
	 * @param route the route with the desired details
	 * @return the updated route as saved in the database
	 */
	@RequestMapping(value = "/routes", method = RequestMethod.POST)
	public Route updateRoute(@RequestBody Route route){
		return routeService.updateRoute(route);
	}

	/**
	 * This method deletes a route from the database by its id number.
	 *
	 * @param id route id number
	 * @return the route deleted from the database
	 */
	@RequestMapping(value = "/routes/id/{id}", method = RequestMethod.DELETE)
	public Route deleteRouteById(@PathVariable("id") int id){
		return routeService.deleteRoute(id);
	}
}
