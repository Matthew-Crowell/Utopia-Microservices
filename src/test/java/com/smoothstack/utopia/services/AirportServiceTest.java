package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Airport;
import com.smoothstack.utopia.repos.AirportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AirportServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AirportServiceTest {

	@MockBean
	private AirportRepository airportRepository;

	@Autowired
	private AirportService airportService;

	private Airport airport;
	private List<Airport> airports;

	@BeforeEach
	void setUp() {
		airport = new Airport();
		airport.setIataId("ABC");
		airport.setCity("Elsewhere");
		airports = new ArrayList<>();
	}

	@Test
	void testAddAirport() {
		when(airportRepository.save(any())).thenReturn(airport);
		assertSame(airport, airportService.addAirport(new Airport()));
		verify(airportRepository).save(any());
		assertTrue(airportService.getAirports().isEmpty());
	}

	@Test
	void testGetAirports() {
		airports.add(airport);
		when(airportRepository.findAll()).thenReturn(airports);
		assertSame(airports, airportService.getAirports());
		verify(airportRepository).findAll();
	}

	@Test
	void getAirportById() {
		when(airportRepository.findById(any())).thenReturn(Optional.of(airport));
		assertSame(airport, airportService.getAirportById(any()));
		verify(airportRepository).findById(any());
	}

	@Test
	void getAirportsByCity() {
		airports.add(airport);
		when(airportRepository.findAirportsByCity(any())).thenReturn(airports);
		assertSame(airports, airportService.getAirportsByCity(any()));
		verify(airportRepository).findAirportsByCity(any());
	}

	@Test
	void updateAirport() {
		Airport airportB = new Airport();
		airportB.setIataId("NOP");
		airportB.setCity("Neverland");
		when(airportRepository.save(any())).thenReturn(airportB);
		when(airportRepository.findById(any())).thenReturn(Optional.of(airport));
		assertSame(airportB, airportService.updateAirport(airport));
		verify(airportRepository).findById(any());
		verify(airportRepository).save(any());
		assertTrue(airportService.getAirports().isEmpty());
	}

	@Test
	void deleteAirportById() {
		doNothing().when(airportRepository).deleteById(any());
		when(airportRepository.findById(any())).thenReturn(Optional.of(airport));
		assertSame(airport, airportService.deleteAirportById("ABC"));
		verify(airportRepository).deleteById(any());
	}
}