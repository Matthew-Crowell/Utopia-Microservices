package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class defines the interface for interacting with the database when
 * working with Route objects.
 *
 * @author matthew.crowell
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

	/**
	 * This method retrieves a list of all flights originating at the
	 * specified airport from the database.
	 *
	 * @param iata the desired airport's iata code
	 * @return a list of all flights originating at the specified airport
	 */
	@Query("SELECT route from Route route WHERE route.origin.iataId = ?1")
	List<Route> findRouteByOriginIATA(String iata);

	/**
	 * This method retrieves a list of all flights originating at the
	 * specified airport from the database.
	 *
	 * @param city the name of the city of origination
	 * @return a list of all flights originating from the desired city
	 */
	@Query("SELECT route from Route route WHERE route.origin.city = ?1")
	List<Route> findRouteByOriginCity(String city);

	/**
	 * This method retrieves a list of all flights destined for the
	 * specified airport from the database.
	 *
	 * @param iata the desired airport's iata code
	 * @return a list of all flights bound for the specified airport
	 */
	@Query("SELECT route from Route route WHERE route.destination.iataId = ?1")
	List<Route> findRouteByDestinationIATA(String iata);

	/**
	 * This method retrieves a list of all flights destined for the
	 * specified airport from the database.
	 *
	 * @param city the name of the destination city
	 * @return a list of all flights bound for the specified airport
	 */
	@Query("SELECT route from Route route WHERE route.destination.city = ?1")
	List<Route> findRouteByDestinationCity(String city);
}
