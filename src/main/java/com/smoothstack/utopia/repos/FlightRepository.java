package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing Flight data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
