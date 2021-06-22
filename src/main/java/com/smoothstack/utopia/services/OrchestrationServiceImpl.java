package com.smoothstack.utopia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrchestrationServiceImpl implements OrchestrationService {

	@Autowired
	private AirplaneService airplaneService;
	@Autowired
	private AirportService airportService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private FlightService flightService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private UserService userService;

	@Override
	public AirplaneService getAirplaneService() {
		return airplaneService;
	}

	@Override
	public AirportService getAirportService() {
		return airportService;
	}

	@Override
	public BookingService getBookingService() {
		return bookingService;
	}

	@Override
	public FlightService getFlightService() {
		return flightService;
	}

	@Override
	public RouteService getRouteService() {
		return routeService;
	}

	@Override
	public UserService getUserService() {
		return userService;
	}
}
