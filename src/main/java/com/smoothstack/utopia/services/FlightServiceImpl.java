package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Airplane;
import com.smoothstack.utopia.entities.Flight;
import com.smoothstack.utopia.entities.Route;
import com.smoothstack.utopia.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;


@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightBookingRepository flightBookingRepository;

	@Autowired
	private AirplaneRepository airplaneRepository;

	@Autowired
	private AirplaneTypeRepository airplaneTypeRepository;

	@Autowired
	private RouteRepository routeRepository;


	@Override
	@Transactional
	public Flight addFlight(Flight flight) {
		Optional<Airplane> airplane = airplaneRepository.findById(flight.getAirplane().getId());
		flight.setAirplane(airplane.orElse(null));
		Optional<Route> route = routeRepository.findById(flight.getRoute().getId());
		flight.setRoute(route.orElse(null));
		flight = flightRepository.save(flight);
		return flight;
	}

	@Override
	@Transactional
	public List<Flight> getFlights() {
		return flightRepository.findAll();
	}

	@Override
	@Transactional
	public Flight getFlightById(int id) {
		return flightRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<Flight> getFlightsByDate(Date date) {
		List<Flight> allFlights = flightRepository.findAll();
		List<Flight> selectedFlights = new ArrayList<>();
		LocalDate targetDate = LocalDate.ofInstant(date.toInstant(), TimeZone.getDefault().toZoneId());

		for (Flight flight : allFlights) {
			LocalDate flightDate = LocalDate.ofInstant(flight.getDepartureTime(), TimeZone.getDefault().toZoneId());
			if (targetDate.equals(flightDate)) {
				selectedFlights.add(flight);
			}
		}
		return selectedFlights;
	}

	@Override
	@Transactional
	public Flight updateFlight(Flight flight) {
		Optional<Flight> updatedFlight = flightRepository.findById(flight.getId());
		Optional<Route> updatedRoute = routeRepository.findById(flight.getRoute().getId());
		Optional<Airplane> updatedAirplane = airplaneRepository.findById(flight.getAirplane().getId());
		Instant updatedDepartureTime = flight.getDepartureTime();
		int updatedReservedSeats = flight.getReservedSeats();
		double updatedSeatPrice = flight.getSeatPrice();
		if (updatedFlight.isPresent()) {
			updatedFlight.get().setRoute(updatedRoute.orElseGet(() -> updatedFlight.get().getRoute()));
			updatedFlight.get().setAirplane(updatedAirplane.orElseGet(() -> updatedFlight.get().getAirplane()));

			if (updatedDepartureTime != null) {
				updatedFlight.get().setDepartureTime(updatedDepartureTime);
			}

			if (updatedReservedSeats >= 0) {
				updatedFlight.get().setReservedSeats(updatedReservedSeats);
			}

			if (updatedSeatPrice >= 0) {
				updatedFlight.get().setSeatPrice(updatedSeatPrice);
			}

			flight = flightRepository.save(updatedFlight.get());
		}

		return flight;
	}

	@Override
	@Transactional
	public Flight deleteFlight(int id) {
		Optional<Flight> flight = flightRepository.findById(id);
		if (flight.isPresent()) {
			flightRepository.deleteById(id);
		}

		return flight.orElse(null);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlightServiceImpl that = (FlightServiceImpl) o;
		return Objects.equals(flightRepository, that.flightRepository) && Objects.equals(flightBookingRepository, that.flightBookingRepository) && Objects.equals(airplaneRepository, that.airplaneRepository) && Objects.equals(airplaneTypeRepository, that.airplaneTypeRepository) && Objects.equals(routeRepository, that.routeRepository);
	}

	@Override
	public int hashCode() {
		return Objects.hash(flightRepository, flightBookingRepository, airplaneRepository, airplaneTypeRepository, routeRepository);
	}
}
