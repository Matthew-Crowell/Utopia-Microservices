package com.smoothstack.utopia.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class representing BookingAgent data in the database.
 *
 * @author matthew.crowell
 */
@Embeddable
public class BookingAgent implements Serializable {

	private int bookingId;
	private int agentId;

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
	 * Get agent id.
	 *
	 * @return int agent id
	 */
	public int getAgentId() {
		return agentId;
	}

	/**
	 * Set agent id.
	 *
	 * @param agentId int agent id
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BookingAgent that = (BookingAgent) o;
		return bookingId == that.bookingId && agentId == that.agentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, agentId);
	}

	@Override
	public String toString() {
		return "BookingAgent{" +
				"bookingId=" + bookingId +
				", agentId=" + agentId +
				'}';
	}
}
