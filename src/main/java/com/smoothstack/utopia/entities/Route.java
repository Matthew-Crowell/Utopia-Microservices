package com.smoothstack.utopia.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class representing Route data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "origin_id")
	private Airport origin;
	@ManyToOne
	@JoinColumn(name = "destination_id")
	private Airport destination;

	/**
	 * Get route id.
	 *
	 * @return int route id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set route id.
	 *
	 * @param id int route id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get origin airport.
	 *
	 * @return Airport origin airport
	 */
	public Airport getOrigin() {
		return origin;
	}

	/**
	 * Set origin airport.
	 *
	 * @param origin Airport origin airport
	 */
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	/**
	 * Get destination airport.
	 *
	 * @return Airport destination airport
	 */
	public Airport getDestination() {
		return destination;
	}

	/**
	 * Set destination airport.
	 *
	 * @param destination Airport destination airport
	 */
	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Route route = (Route) o;
		return id == route.id && Objects.equals(origin, route.origin) && Objects.equals(destination, route.destination);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, origin, destination);
	}

	@Override
	public String toString() {
		return "Route{" +
				"id=" + id +
				", origin=" + origin +
				", destination=" + destination +
				'}';
	}
}
