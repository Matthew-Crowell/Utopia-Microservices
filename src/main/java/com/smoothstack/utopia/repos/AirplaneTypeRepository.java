package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing AirplaneType data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Integer> {
}
