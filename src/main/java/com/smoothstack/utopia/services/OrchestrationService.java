package com.smoothstack.utopia.services;

/**
 * This defines the interface for interacting with the orchestration service.
 *
 * @author matthew.crowell
 */
public interface OrchestrationService {
	/**
	 * This method grants the caller access to an airplane service.
	 *
	 * @return an airport service object
	 */
	AirplaneService getAirplaneService();

	/**
	 * This method grants the caller access to an airport service.
	 *
	 * @return an airport service object
	 */
	AirportService getAirportService();

	/**
	 * This method grants the caller access to a booking service.
	 *
	 * @return a booking service object
	 */
	BookingService getBookingService();

	/**
	 * This method grants the caller access to a flight service.
	 *
	 * @return a flight service object
	 */
	FlightService getFlightService();

	/**
	 * This method grants the caller access to a route service.
	 *
	 * @return a route service object
	 */
	RouteService getRouteService();

	/**
	 * This method grants the caller access to a user service.
	 *
	 * @return a user service object
	 */
	UserService getUserService();
}
