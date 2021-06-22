package com.smoothstack.utopia.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.smoothstack.utopia.entities.Airplane;
import com.smoothstack.utopia.entities.AirplaneType;
import com.smoothstack.utopia.repos.AirplaneRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AirplaneServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class AirplaneServiceImplTest {
	@MockBean
	private AirplaneRepository airplaneRepository;

	@Autowired
	private AirplaneServiceImpl airplaneServiceImpl;

	@Test
	public void testAddAirplane() {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setMaxCapacity(3);
		airplaneType.setId(1);

		Airplane airplane = new Airplane();
		airplane.setId(1);
		airplane.setType(airplaneType);
		when(this.airplaneRepository.save((Airplane) any())).thenReturn(airplane);
		assertSame(airplane, this.airplaneServiceImpl.addAirplane(new Airplane()));
		verify(this.airplaneRepository).save((Airplane) any());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testGetAirplanes() {
		ArrayList<Airplane> airplaneList = new ArrayList<Airplane>();
		when(this.airplaneRepository.findAll()).thenReturn(airplaneList);
		List<Airplane> actualAirplanes = this.airplaneServiceImpl.getAirplanes();
		assertSame(airplaneList, actualAirplanes);
		assertTrue(actualAirplanes.isEmpty());
		verify(this.airplaneRepository).findAll();
	}

	@Test
	public void testGetAirplaneById() {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setMaxCapacity(3);
		airplaneType.setId(1);

		Airplane airplane = new Airplane();
		airplane.setId(1);
		airplane.setType(airplaneType);
		Optional<Airplane> ofResult = Optional.<Airplane>of(airplane);
		when(this.airplaneRepository.findById((Integer) any())).thenReturn(ofResult);
		assertSame(airplane, this.airplaneServiceImpl.getAirplaneById(1));
		verify(this.airplaneRepository).findById((Integer) any());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testGetAirplanesByType() {
		ArrayList<Airplane> airplaneList = new ArrayList<Airplane>();
		when(this.airplaneRepository.findAirplaneByType(anyInt())).thenReturn(airplaneList);
		List<Airplane> actualAirplanesByType = this.airplaneServiceImpl.getAirplanesByType(1);
		assertSame(airplaneList, actualAirplanesByType);
		assertTrue(actualAirplanesByType.isEmpty());
		verify(this.airplaneRepository).findAirplaneByType(anyInt());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testUpdateAirplane() {
		when(this.airplaneRepository.findById((Integer) any())).thenReturn(Optional.<Airplane>empty());
		Airplane airplane = new Airplane();
		assertSame(airplane, this.airplaneServiceImpl.updateAirplane(airplane));
		verify(this.airplaneRepository).findById((Integer) any());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testUpdateAirplane2() {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setMaxCapacity(3);
		airplaneType.setId(1);

		Airplane airplane = new Airplane();
		airplane.setId(1);
		airplane.setType(airplaneType);
		Optional<Airplane> ofResult = Optional.<Airplane>of(airplane);

		AirplaneType airplaneType1 = new AirplaneType();
		airplaneType1.setMaxCapacity(3);
		airplaneType1.setId(1);

		Airplane airplane1 = new Airplane();
		airplane1.setId(1);
		airplane1.setType(airplaneType1);
		when(this.airplaneRepository.save((Airplane) any())).thenReturn(airplane1);
		when(this.airplaneRepository.findById((Integer) any())).thenReturn(ofResult);

		AirplaneType airplaneType2 = new AirplaneType();
		airplaneType2.setMaxCapacity(3);
		airplaneType2.setId(1);

		Airplane airplane2 = new Airplane();
		airplane2.setType(airplaneType2);
		assertSame(airplane1, this.airplaneServiceImpl.updateAirplane(airplane2));
		verify(this.airplaneRepository).findById((Integer) any());
		verify(this.airplaneRepository).save((Airplane) any());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testUpdateAirplane3() {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setMaxCapacity(3);
		airplaneType.setId(1);

		Airplane airplane = new Airplane();
		airplane.setId(1);
		airplane.setType(airplaneType);
		Optional<Airplane> ofResult = Optional.<Airplane>of(airplane);

		AirplaneType airplaneType1 = new AirplaneType();
		airplaneType1.setMaxCapacity(3);
		airplaneType1.setId(1);

		Airplane airplane1 = new Airplane();
		airplane1.setId(1);
		airplane1.setType(airplaneType1);
		when(this.airplaneRepository.save((Airplane) any())).thenReturn(airplane1);
		when(this.airplaneRepository.findById((Integer) any())).thenReturn(ofResult);

		AirplaneType airplaneType2 = new AirplaneType();
		airplaneType2.setMaxCapacity(3);
		airplaneType2.setId(0);

		Airplane airplane2 = new Airplane();
		airplane2.setType(airplaneType2);
		assertSame(airplane1, this.airplaneServiceImpl.updateAirplane(airplane2));
		verify(this.airplaneRepository).findById((Integer) any());
		verify(this.airplaneRepository).save((Airplane) any());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testUpdateAirplane4() {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setMaxCapacity(3);
		airplaneType.setId(1);

		Airplane airplane = new Airplane();
		airplane.setId(1);
		airplane.setType(airplaneType);
		Optional<Airplane> ofResult = Optional.<Airplane>of(airplane);

		AirplaneType airplaneType1 = new AirplaneType();
		airplaneType1.setMaxCapacity(3);
		airplaneType1.setId(1);

		Airplane airplane1 = new Airplane();
		airplane1.setId(1);
		airplane1.setType(airplaneType1);
		when(this.airplaneRepository.save((Airplane) any())).thenReturn(airplane1);
		when(this.airplaneRepository.findById((Integer) any())).thenReturn(ofResult);

		AirplaneType airplaneType2 = new AirplaneType();
		airplaneType2.setMaxCapacity(3);
		airplaneType2.setId(1);

		Airplane airplane2 = new Airplane();
		airplane2.setId(1);
		airplane2.setType(airplaneType2);
		assertSame(airplane1, this.airplaneServiceImpl.updateAirplane(airplane2));
		verify(this.airplaneRepository).findById((Integer) any());
		verify(this.airplaneRepository).save((Airplane) any());
		assertEquals(airplane, airplane2);
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testDeleteAirplane() {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setMaxCapacity(3);
		airplaneType.setId(1);

		Airplane airplane = new Airplane();
		airplane.setId(1);
		airplane.setType(airplaneType);
		Optional<Airplane> ofResult = Optional.<Airplane>of(airplane);
		doNothing().when(this.airplaneRepository).deleteById((Integer) any());
		when(this.airplaneRepository.findById((Integer) any())).thenReturn(ofResult);
		assertSame(airplane, this.airplaneServiceImpl.deleteAirplane(1));
		verify(this.airplaneRepository).deleteById((Integer) any());
		verify(this.airplaneRepository).findById((Integer) any());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}

	@Test
	public void testDeleteAirplane2() {
		doNothing().when(this.airplaneRepository).deleteById((Integer) any());
		when(this.airplaneRepository.findById((Integer) any())).thenReturn(Optional.<Airplane>empty());
		assertNull(this.airplaneServiceImpl.deleteAirplane(1));
		verify(this.airplaneRepository).findById((Integer) any());
		assertTrue(this.airplaneServiceImpl.getAirplanes().isEmpty());
	}
}

