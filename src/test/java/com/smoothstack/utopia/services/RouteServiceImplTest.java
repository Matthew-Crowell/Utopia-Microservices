package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Airport;
import com.smoothstack.utopia.entities.Route;
import com.smoothstack.utopia.repos.RouteRepository;
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
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RouteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RouteServiceImplTest {

	@MockBean
	private RouteRepository routeRepository;

	@Autowired
	private RouteService routeService;

	private Route route;
	private List<Route> routes;
	private Airport origin;
	private Airport destination;

	@BeforeEach
	void setUp() {
		route = new Route();
		routes = new ArrayList<>();
		origin = new Airport();
		destination = new Airport();

		origin.setIataId("ABC");
		destination.setIataId("XYZ");

		origin.setCity("Someplace");
		destination.setCity("Elsewhere");

		route.setId(1);
		route.setOrigin(origin);
		route.setDestination(destination);

		routes.add(route);
	}

	@Test
	void addRoute() {
		when(routeRepository.save(any())).thenReturn(route);
		assertSame(route, routeService.addRoute(route));
		verify(routeRepository).save(any());
	}

	@Test
	void getRoutes() {
		when(routeRepository.findAll()).thenReturn(routes);
		assertSame(routes, routeService.getRoutes());
		verify(routeRepository).findAll();
	}

	@Test
	void getRouteById() {
		when(routeRepository.findById(any())).thenReturn(Optional.of(route));
		assertSame(route, routeService.getRouteById(1));
		verify(routeRepository).findById(any());
	}

	@Test
	void getRoutesByOriginIATA() {
		when(routeRepository.findRouteByOriginIATA(any())).thenReturn(routes);
		assertSame(routes, routeService.getRoutesByOriginIATA("ABC"));
		verify(routeRepository).findRouteByOriginIATA(any());
	}

	@Test
	void getRoutesByOriginCity() {
		when(routeRepository.findRouteByOriginCity(any())).thenReturn(routes);
		assertSame(routes, routeService.getRoutesByOriginCity("Someplace"));
		verify(routeRepository).findRouteByOriginCity(any());
	}

	@Test
	void getRoutesByDestinationIATA() {
		when(routeRepository.findRouteByDestinationIATA(any())).thenReturn(routes);
		assertSame(routes, routeService.getRoutesByDestinationIATA("XYZ"));
		verify(routeRepository).findRouteByDestinationIATA(any());
	}

	@Test
	void getRoutesByDestinationCity() {
		when(routeRepository.findRouteByDestinationCity(any())).thenReturn(routes);
		assertSame(routes, routeService.getRoutesByDestinationCity("Elsewhere"));
		verify(routeRepository).findRouteByDestinationCity(any());
	}

	@Test
	void updateRoute() {
		Route routeB = new Route();
		routeB.setId(2);
		routeB.setOrigin(route.getDestination());
		routeB.setDestination(route.getOrigin());
		when(routeRepository.findById(any())).thenReturn(Optional.of(route));
		when(routeRepository.save(any())).thenReturn(routeB);
		assertSame(routeB, routeService.updateRoute(route));
		verify(routeRepository).findById(any());
		verify(routeRepository).save(any());
	}

	@Test
	void deleteRoute() {
		when(routeRepository.findById(any())).thenReturn(Optional.of(route));
		doNothing().when(routeRepository).deleteById(any());
		assertSame(route, routeService.deleteRoute(route.getId()));
		verify(routeRepository).findById(any());
		verify(routeRepository).deleteById(any());
	}
}