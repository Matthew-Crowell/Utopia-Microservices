package com.smoothstack.utopia.repos;

import com.smoothstack.utopia.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for accessing Airplane data from the database.
 *
 * @author matthew.crowell
 */
@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

	/**
	 * Find all airplanes of a specified type.
	 *
	 * @param type int airplane type
	 * @return List<Airplane> list of all airplanes of specified type
	 */
	@Query("SELECT airplane FROM Airplane airplane WHERE airplane.type.id = ?1")
	List<Airplane> findAirplaneByType(int type);
}
