package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.*;
import com.smoothstack.utopia.repos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 * This class tests the Flight service impl.
 *
 * @author matthew.crowell
 */
@ContextConfiguration(classes = {FlightServiceImpl.class})
@ExtendWith(SpringExtension.class)
class FlightServiceImplTest {

	@MockBean
	private AirplaneRepository airplaneRepository;

	@MockBean
	private AirplaneTypeRepository airplaneTypeRepository;

	@MockBean
	private FlightRepository flightRepository;

	@MockBean
	private FlightBookingRepository flightBookingRepository;

	@MockBean
	private RouteRepository routeRepository;

	@Autowired
	private FlightService flightService;

	private Airplane plane;
	private AirplaneType type;
	private Airport origin;
	private Airport destination;
	private Flight flight;
	private FlightBooking flightBooking;
	private Instant departureTime;
	private List<Flight> flights;
	private Route route;

	/**
	 * This method prepares the objects needed for the tests.
	 */
	@BeforeEach
	void setUp() {
		plane = new Airplane();
		type = new AirplaneType();
		origin = new Airport();
		destination = new Airport();
		flight = new Flight();
		flightBooking = new FlightBooking();
		departureTime = Instant.now();
		flights = new ArrayList<>();
		route = new Route();

		origin.setIataId("ABC");
		origin.setCity("Someplace");

		destination.setIataId("XYZ");
		destination.setCity("Elsewhere");

		route.setId(1);
		route.setOrigin(origin);
		route.setDestination(destination);

		type.setId(1);
		type.setMaxCapacity(200);

		plane.setId(1);
		plane.setType(type);

		flight.setId(1);
		flight.setAirplane(plane);
		flight.setRoute(route);
		flight.setDepartureTime(departureTime);
		flight.setReservedSeats(0);
		flight.setSeatPrice(399.99);

		flights.add(flight);
	}

	/**
	 * This method tests the addFlight method.
	 */
	@Test
	void addFlight() {
		when(airplaneRepository.findById(any())).thenReturn(Optional.of(plane));
		when(routeRepository.findById(any())).thenReturn(Optional.of(route));
		when(flightRepository.save(any())).thenReturn(flight);
		assertSame(flight, flightService.addFlight(flight));
		verify(airplaneRepository).findById(any());
		verify(routeRepository).findById(any());
		verify(flightRepository).save(any());
	}

	/**
	 * Gets flights.
	 */
	@Test
	void getFlights() {
		when(flightRepository.findAll()).thenReturn(flights);
		assertSame(flights, flightService.getFlights());
		verify(flightRepository).findAll();
	}

	/**
	 * Gets flight by id.
	 */
	@Test
	void getFlightById() {
		when(flightRepository.findById(any())).thenReturn(Optional.of(flight));
		assertSame(flight, flightService.getFlightById(flight.getId()));
		verify(flightRepository).findById(any());
	}

	/**
	 * Gets flights by date.
	 */
	@Test
	void getFlightsByDate() {
		when(flightRepository.findAll()).thenReturn(flights);
		assertEquals(flights, flightService
				.getFlightsByDate(Date.from(departureTime)));
		verify(flightRepository).findAll();
	}

	/**
	 * Update flight.
	 */
	@Test
	void updateFlight() {
		Flight flightB = new Flight();
		flightB.setId(1);
		flightB.setAirplane(plane);
		flightB.setRoute(route);
		flightB.setDepartureTime(departureTime);
		flightB.setReservedSeats(30);
		flightB.setSeatPrice(399.99);

		when(flightRepository.findById(any())).thenReturn(Optional.of(flight));
		when(routeRepository.findById(any())).thenReturn(Optional.of(route));
		when(airplaneRepository.findById(any())).thenReturn(Optional.of(plane));
		when(flightRepository.save(any())).thenReturn(flightB);
		assertSame(flightB, flightService.updateFlight(flight));
		verify(flightRepository).findById(any());
		verify(routeRepository).findById(any());
		verify(airplaneRepository).findById(any());
		verify(flightRepository).save(any());
	}

	/**
	 * Delete flight.
	 */
	@Test
	void deleteFlight() {
		when(flightRepository.findById(any())).thenReturn(Optional.of(flight));
		doNothing().when(flightRepository).deleteById(any());
		assertSame(flight, flightService.deleteFlight(flight.getId()));
		verify(flightRepository).findById(any());
		verify(flightRepository).deleteById(any());
	}

	/**
	 * Test equals.
	 */
	@Test
	void testEquals() {
		assertEquals(flightService, flightService);
	}

	/**
	 * Test equals, expected false.
	 */
	@Test
	void testEqualsExpectedFalse() {
		FlightService second = new FlightServiceImpl();
		assertNotEquals(flightService, second);
	}

	/**
	 * Test hash code.
	 */
	@Test
	void testHashCode() {
		assertEquals(flightService.hashCode(), flightService.hashCode());
	}

	/**
	 * Test hash code expected false.
	 */
	@Test
	void testHashCodeExpectedFalse() {
		FlightService second = new FlightServiceImpl();
		assertNotEquals(flightService.hashCode(), second.hashCode());
	}
}