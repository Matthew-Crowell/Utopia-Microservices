package com.smoothstack.utopia.entities;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Class representing BookingPayment data in the database.
 *
 * @author matthew.crowell
 */
@Embeddable
public class BookingPayment {
	private int bookingId;
	private String stripeId;
	private boolean refunded;

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
	 * Get stripe id.
	 *
	 * @return String stripe id
	 */
	public String getStripeId() {
		return stripeId;
	}

	/**
	 * Set stripe id.
	 *
	 * @param stripeId String stripe id
	 */
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}

	/**
	 * Get refunded status.
	 *
	 * @return boolean true if payment has been refunded
	 */
	public boolean getRefunded() {
		return refunded;
	}

	/**
	 * Set refunded status.
	 *
	 * @param refunded boolean true if payment has been refunded
	 */
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BookingPayment that = (BookingPayment) o;
		return bookingId == that.bookingId && refunded == that.refunded && Objects.equals(stripeId, that.stripeId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, stripeId, refunded);
	}

	@Override
	public String toString() {
		return "BookingPayment{" +
				"bookingId=" + bookingId +
				", stripeId='" + stripeId + '\'' +
				", refunded=" + refunded +
				'}';
	}
}
