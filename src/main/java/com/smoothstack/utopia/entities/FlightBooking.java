package com.smoothstack.utopia.entities;

import com.smoothstack.utopia.ids.FlightBookingId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class representing FlightBooking data in the database.
 *
 * @author matthew.crowell
 */
@Entity
@Table(name = "flight_bookings")
@IdClass(FlightBookingId.class)
public class FlightBooking implements Serializable {
	@Id
	private int flightId;
	@Id
	private int bookingId;


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
		FlightBooking that = (FlightBooking) o;
		return flightId == that.flightId && bookingId == that.bookingId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flightId, bookingId);
	}

	@Override
	public String toString() {
		return "FlightBooking{" +
				"flightId=" + flightId +
				", bookingId=" + bookingId +
				'}';
	}
}