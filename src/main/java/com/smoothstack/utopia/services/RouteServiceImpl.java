package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.Route;
import com.smoothstack.utopia.repos.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Override
	@Transactional
	public Route addRoute(Route route) {
		return routeRepository.save(route);
	}

	@Override
	@Transactional
	public List<Route> getRoutes() {
		return routeRepository.findAll();
	}

	@Override
	@Transactional
	public Route getRouteById(int id) {
		return routeRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<Route> getRoutesByOriginIATA(String iata) {
		return routeRepository.findRouteByOriginIATA(iata);
	}

	@Override
	@Transactional
	public List<Route> getRoutesByOriginCity(String city) {
		return routeRepository.findRouteByOriginCity(city);
	}

	@Override
	@Transactional
	public List<Route> getRoutesByDestinationIATA(String iata) {
		return routeRepository.findRouteByDestinationIATA(iata);
	}

	@Override
	@Transactional
	public List<Route> getRoutesByDestinationCity(String city) {
		return routeRepository.findRouteByDestinationCity(city);
	}

	@Override
	@Transactional
	public Route updateRoute(Route route) {
		Optional<Route> updatedRoute = routeRepository.findById(route.getId());
		if(updatedRoute.isPresent()){
			if(route.getOrigin().getIataId().length() > 0){
				updatedRoute.get().setOrigin(route.getOrigin());
			}

			if(route.getDestination().getIataId().length() > 0){
				updatedRoute.get().setDestination(route.getDestination());
			}

			route = routeRepository.save(updatedRoute.get());
		}

		return route;
	}

	@Override
	@Transactional
	public Route deleteRoute(int id) {
		Optional<Route> route = routeRepository.findById(id);
		if(route.isPresent()){
			routeRepository.deleteById(id);
		}
		return route.orElse(null);
	}
}
