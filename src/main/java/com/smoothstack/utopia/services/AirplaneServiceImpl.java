package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Airplane;
import com.smoothstack.utopia.repos.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * This class implements the business logic of the AirplaneService interface.
 *
 * @author matthew.crowell
 */
@Service
public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	private AirplaneRepository airplaneRepository;

	@Override
	@Transactional
	public Airplane addAirplane(Airplane airplane) {
		return airplaneRepository.save(airplane);
	}

	@Override
	@Transactional
	public List<Airplane> getAirplanes() {
		return airplaneRepository.findAll();
	}

	@Override
	@Transactional
	public Airplane getAirplaneById(int id) {
		return airplaneRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<Airplane> getAirplanesByType(int type) {
		return airplaneRepository.findAirplaneByType(type);
	}

	@Override
	@Transactional
	public Airplane updateAirplane(Airplane airplane) {
		Optional<Airplane> updatedAirplane = airplaneRepository.findById((airplane.getId()));
		if (updatedAirplane.isPresent()) {
			if (airplane.getId() > 0) {
				updatedAirplane.get().setId(airplane.getId());
			}

			if (airplane.getType().getId() > 0) {
				updatedAirplane.get().setType(airplane.getType());
			}

			airplane = airplaneRepository.save(updatedAirplane.get());
		}
		return airplane;
	}

	@Override
	@Transactional
	public Airplane deleteAirplane(int id) {
		Optional<Airplane> airplane = airplaneRepository.findById(id);
		if (airplane.isPresent()) {
			airplaneRepository.deleteById(id);
		}
		return airplane.orElse(null);
	}
}
