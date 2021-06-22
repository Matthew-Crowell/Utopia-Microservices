package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing FlightStatus data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface FlightStatusRepository extends JpaRepository<FlightStatus, Integer> {
}
