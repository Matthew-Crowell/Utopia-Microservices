package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Airport;
import com.smoothstack.utopia.repos.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	private AirportRepository airportRepository;

	@Override
	@Transactional
	public Airport addAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	@Transactional
	public List<Airport> getAirports() {
		return airportRepository.findAll();
	}

	@Override
	@Transactional
	public Airport getAirportById(String iata) {
		return airportRepository.findById(iata).orElse(null);
	}

	@Override
	@Transactional
	public List<Airport> getAirportsByCity(String city) {
		return airportRepository.findAirportsByCity(city);
	}

	@Override
	@Transactional
	public Airport updateAirport(Airport airport) {
		Optional<Airport> updatedAirport = airportRepository.findById(airport.getIataId());

		if (updatedAirport.isPresent()) {
			if (airport.getIataId().length() > 0) {
				updatedAirport.get().setIataId(airport.getIataId());
			}

			if (airport.getCity().length() > 0) {
				updatedAirport.get().setCity(airport.getCity());
			}

			airport = airportRepository.save(updatedAirport.get());
		}
		return airport;
	}

	@Override
	@Transactional
	public Airport deleteAirportById(String iata) {
		Optional<Airport> airport = airportRepository.findById(iata);

		if (airport.isPresent()) {
			airportRepository.deleteById(iata);
		}

		return airport.orElse(null);
	}
}
