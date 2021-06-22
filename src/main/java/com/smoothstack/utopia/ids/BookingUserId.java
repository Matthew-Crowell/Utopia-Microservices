package com.smoothstack.utopia.ids;

import java.util.Objects;

/**
 * Composite id key for BookingUser entity.
 *
 * @author matthew.crowell
 */
public class BookingUserId implements java.io.Serializable {
	int bookingId;
	int userId;

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
	 * Get user id.
	 *
	 * @return int user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Set user id.
	 *
	 * @param userId int user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BookingUserId that = (BookingUserId) o;
		return bookingId == that.bookingId && userId == that.userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, userId);
	}

	@Override
	public String toString() {
		return "BookingUserId{" +
				"bookingId=" + bookingId +
				", userId=" + userId +
				'}';
	}
}
