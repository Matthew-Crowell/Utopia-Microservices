package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Route;

import java.util.List;

/**
 * Interface for the Route service.
 *
 * @author matthew.crowell
 */
public interface RouteService {

	/**
	 * This method adds a new route to the database.
	 *
	 * @param route route to create
	 * @return the route that was saved to the database
	 */
	Route addRoute(Route route);

	/**
	 * This method gets a list of all routes from the database.
	 *
	 * @return a list of all routes found in the database
	 */
	List<Route> getRoutes();

	/**
	 * This method retrieves a route from the database with the specified id.
	 *
	 * @param id int representing the route id
	 * @return the requested route
	 */
	Route getRouteById(int id);

	/**
	 * This method returns a list of routes that originate from a specific airport,
	 * identified by iata code, from the database.
	 *
	 * @param iata the string iata code of the desired airport of origination
	 * @return a list of all routes originating at the given airport
	 */
	List<Route> getRoutesByOriginIATA(String iata);

	/**
	 * This method returns a list of routes that originate from a specific airport,
	 * identified by abbreviated city name, from the database.
	 *
	 * @param city the string abbreviation of the city name of the desired airport of origination
	 * @return a list of all routes originating at the given airport
	 */
	List<Route> getRoutesByOriginCity(String city);

	/**
	 * This method returns a list of routes that destined for a specific airport,
	 * identified by iata code, from the database.
	 *
	 * @param iata the string iata code of the desired destination airport
	 * @return a list of all routes arriving at the given airport
	 */
	List<Route> getRoutesByDestinationIATA(String iata);

	/**
	 * This method returns a list of routes that are destined for a specific airport,
	 * identified by abbreviated city name, from the database.
	 *
	 * @param city the string abbreviation of the city name of the desired destination airport
	 * @return a list of all routes arriving at the given airport
	 */

	List<Route> getRoutesByDestinationCity(String city);

	/**
	 * This method updates a route in the database with the information contained in the route parameter.
	 *
	 * @param route a route object with the updated information for the targeted route
	 * @return the updated route object from the database
	 */
	Route updateRoute(Route route);

	/**
	 * This method deletes a route by its id number.
	 *
	 * @param id the route id number
	 * @return the route that was deleted from the database
	 */
	Route deleteRoute(int id);
}
