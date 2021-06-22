package com.smoothstack.utopia.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * Class representing Flight data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Route route;
	@ManyToOne
	private Airplane airplane;
	private Instant departureTime;
	private int reservedSeats;
	private double seatPrice;

	/**
	 * Default constructor.
	 */
	public Flight() {
	}

	/**
	 * Parameterized constructor.
	 * @param id int assigned id number
	 * @param route Route assigned route
	 * @param airplane Airplane assigned airplane
	 * @param departureTime Instant estimated time of departure
	 * @param reservedSeats int number of reserved seats
	 * @param seatPrice double price per seat
	 * @param flightBookings List<FlightBooking> list of associated flight bookings
	 */
	public Flight(int id, Route route, Airplane airplane, Instant departureTime, int reservedSeats, double seatPrice, List<FlightBooking> flightBookings) {
		this.id = id;
		this.route = route;
		this.airplane = airplane;
		this.departureTime = departureTime;
		this.reservedSeats = reservedSeats;
		this.seatPrice = seatPrice;
	}

	/**
	 * Get flight id number.
	 * @return int flight id number
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set flight id number.
	 * @param id int flight id number
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get assigned route.
	 * @return Route assigned route
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * Set assigned route.
	 * @param route Route assigned route
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	/**
	 * Get assigned airplane.
	 * @return Airplane assigned airplane
	 */
	public Airplane getAirplane() {
		return airplane;
	}

	/**
	 * Set assigned airplane.
	 * @param airplane Airplane assigned airplane
	 */
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	/**
	 * Get estimated departure time.
	 * @return Instant estimated departure time
	 */
	public Instant getDepartureTime() {
		return departureTime;
	}

	/**
	 * Set estimated departure time.
	 * @param departureTime Instant estimated departure time
	 */
	public void setDepartureTime(Instant departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * Get number of reserved seats.
	 * @return int number of reserved seats
	 */
	public int getReservedSeats() {
		return reservedSeats;
	}

	/**
	 * Set number of reserved seats.
	 * @param reservedSeats int number of reserved seats
	 */
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	/**
	 * Get price per seat.
	 * @return double price per seat
	 */
	public double getSeatPrice() {
		return seatPrice;
	}

	/**
	 * Set price per seat.
	 * @param seatPrice double price per seat
	 */
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Flight flight = (Flight) o;
		return id == flight.id && reservedSeats == flight.reservedSeats && Double.compare(flight.seatPrice, seatPrice) == 0 && Objects.equals(route, flight.route) && Objects.equals(airplane, flight.airplane) && Objects.equals(departureTime, flight.departureTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, route, airplane, departureTime, reservedSeats, seatPrice);
	}

	@Override
	public String toString() {
		return "Flight{" +
				"id=" + id +
				", route=" + route +
				", airplane=" + airplane +
				", departureTime=" + departureTime +
				", reservedSeats=" + reservedSeats +
				", seatPrice=" + seatPrice +
				'}';
	}
}