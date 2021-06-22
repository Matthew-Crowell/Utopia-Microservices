package com.smoothstack.utopia.ids;

import java.util.Objects;

/**
 * Composite id key for FlightBooking entity.
 *
 * @author matthew.crowell
 */
public class FlightBookingId implements java.io.Serializable {
	int flightId;
	int bookingId;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlightBookingId that = (FlightBookingId) o;
		return flightId == that.flightId && bookingId == that.bookingId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flightId, bookingId);
	}

	@Override
	public String toString() {
		return "FlightBookingId{" +
				"flightId=" + flightId +
				", bookingId=" + bookingId +
				'}';
	}
}
