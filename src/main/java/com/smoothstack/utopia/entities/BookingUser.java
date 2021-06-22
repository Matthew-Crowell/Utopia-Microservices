package com.smoothstack.utopia.entities;

import com.smoothstack.utopia.ids.BookingUserId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

/**
 * Class representing BookingUser data in the database.
 *
 * @author matthew.crowell
 */
@Entity
@IdClass(BookingUserId.class)
public class BookingUser {
	@Id
	private int bookingId;
	@Id
	private int userId;

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
		BookingUser that = (BookingUser) o;
		return bookingId == that.bookingId && userId == that.userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, userId);
	}

	@Override
	public String toString() {
		return "BookingUser{" +
				"bookingId=" + bookingId +
				", userId=" + userId +
				'}';
	}
}
