package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.FlightPassenger;
import com.smoothstack.utopia.ids.FlightPassengerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing FlightPassenger data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface FlightPassengerRepository extends JpaRepository<FlightPassenger, FlightPassengerId> {

}
