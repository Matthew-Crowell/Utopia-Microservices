package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for accessing Airport data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {

	/**
	 * This method retrieves the data for all airports in the target city from the database.
	 *
	 * @param city the name of the target city
	 * @return the list of all airports found in the given city
	 */
	@Query("SELECT airport from Airport airport WHERE airport.city = ?1")
	List<Airport> findAirportsByCity(String city);
}
