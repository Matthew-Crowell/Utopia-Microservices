package com.smoothstack.utopia.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Objects;

/**
 * Class representing FlightStatus data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class FlightStatus {
	@Id
	private int id;
	private int routeId;
	private int airplaneId;
	private Instant departureTime;
	private int reservedSeats;
	private double seatPrice;
	private int maxCapacity;
	private long passengerCount;
	private long availableSeats;

	/**
	 * Get flight status id.
	 *
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * set flight status id.
	 *
	 * @param id int id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get route id.
	 *
	 * @return int route id
	 */
	public int getRouteId() {
		return routeId;
	}

	/**
	 * Set route id.
	 *
	 * @param routeId int route id
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	/**
	 * Get airplane id.
	 *
	 * @return int airplane id
	 */
	public int getAirplaneId() {
		return airplaneId;
	}

	/**
	 * Set airplane id.
	 *
	 * @param airplaneId int airplane id
	 */
	public void setAirplaneId(int airplaneId) {
		this.airplaneId = airplaneId;
	}

	/**
	 * Get departure time.
	 *
	 * @return Instant departure time
	 */
	public Instant getDepartureTime() {
		return departureTime;
	}

	/**
	 * Set departure time.
	 *
	 * @param departureTime Instant departure time
	 */
	public void setDepartureTime(Instant departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * Get the number of reserved seats.
	 *
	 * @return int reserved seats
	 */
	public int getReservedSeats() {
		return reservedSeats;
	}

	/**
	 * Set the number of reserved seats.
	 *
	 * @param reservedSeats int reserved seats
	 */
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	/**
	 * Get ticket price per seat.
	 *
	 * @return double price per seat
	 */
	public double getSeatPrice() {
		return seatPrice;
	}

	/**
	 * Set ticket price per seat.
	 *
	 * @param seatPrice double price per seat
	 */
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	/**
	 * Get maximum passenger capacity.
	 *
	 * @return int maximum passenger capacity
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * Set maximum passenger capacity.
	 *
	 * @param maxCapacity int maximum passenger capacity
	 */
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * Get the number of actual passengers.
	 *
	 * @return long passenger count
	 */
	public long getPassengerCount() {
		return passengerCount;
	}

	/**
	 * Set the number of actual passengers.
	 *
	 * @param passengerCount int passenger count
	 */
	public void setPassengerCount(long passengerCount) {
		this.passengerCount = passengerCount;
	}

	/**
	 * Get the number of seats remaining.
	 *
	 * @return int number of remaining seats
	 */
	public long getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * Set the number of remaining seats.
	 *
	 * @param availableSeats int number of remaining seats
	 */
	public void setAvailableSeats(long availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlightStatus that = (FlightStatus) o;
		return id == that.id && routeId == that.routeId && airplaneId == that.airplaneId && reservedSeats == that.reservedSeats && Double.compare(that.seatPrice, seatPrice) == 0 && maxCapacity == that.maxCapacity && passengerCount == that.passengerCount && availableSeats == that.availableSeats && Objects.equals(departureTime, that.departureTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, routeId, airplaneId, departureTime, reservedSeats, seatPrice, maxCapacity, passengerCount, availableSeats);
	}

	@Override
	public String toString() {
		return "FlightStatus{" +
				"id=" + id +
				", routeId=" + routeId +
				", airplaneId=" + airplaneId +
				", departureTime=" + departureTime +
				", reservedSeats=" + reservedSeats +
				", seatPrice=" + seatPrice +
				", maxCapacity=" + maxCapacity +
				", passengerCount=" + passengerCount +
				", availableSeats=" + availableSeats +
				'}';
	}
}
