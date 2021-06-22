package com.smoothstack.utopia.ids;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite id key for FlightPassenger entity.
 *
 * @author matthew.crowell
 */
public class FlightPassengerId implements Serializable {
	int flightId;
	int bookingId;
	int passengerId;

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
		FlightPassengerId that = (FlightPassengerId) o;
		return flightId == that.flightId && bookingId == that.bookingId && passengerId == that.passengerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flightId, bookingId, passengerId);
	}

	@Override
	public String toString() {
		return "FlightPassengerId{" +
				"flightId=" + flightId +
				", bookingId=" + bookingId +
				", passengerId=" + passengerId +
				'}';
	}
}
