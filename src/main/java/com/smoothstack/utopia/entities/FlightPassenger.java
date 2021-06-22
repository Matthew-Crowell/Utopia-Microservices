package com.smoothstack.utopia.entities;

import com.smoothstack.utopia.ids.FlightPassengerId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Class representing FlightPassenger data in the database.
 *
 * @author matthew.crowell
 */
@Entity
@IdClass(FlightPassengerId.class)
@Table(name = "flight_passengers")
public class FlightPassenger {
	@Id
	private int flightId;
	@Id
	private int bookingId;
	@Id
	private int passengerId;

	/**
	 * Get flight id.
	 *
	 * @return int flight id
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * Set flight id.
	 *
	 * @param flightId int flight id
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	/**
	 * Get booking id.
	 *
	 * @return int booking id
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Set booking id.
	 *
	 * @param bookingId int booking id
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * Get passenger id.
	 *
	 * @return int passenger id
	 */
	public int getPassengerId() {
		return passengerId;
	}

	/**
	 * Set passenger id.
	 *
	 * @param passengerId int passenger id
	 */
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlightPassenger that = (FlightPassenger) o;
		return flightId == that.flightId && bookingId == that.bookingId && passengerId == that.passengerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flightId, bookingId, passengerId);
	}

	@Override
	public String toString() {
		return "FlightPassenger{" +
				"flightId=" + flightId +
				", bookingId=" + bookingId +
				", passengerId=" + passengerId +
				'}';
	}
}
