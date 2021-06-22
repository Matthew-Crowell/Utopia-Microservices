package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.FlightBooking;
import com.smoothstack.utopia.ids.FlightBookingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing FlightBooking data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, FlightBookingId> {
}
