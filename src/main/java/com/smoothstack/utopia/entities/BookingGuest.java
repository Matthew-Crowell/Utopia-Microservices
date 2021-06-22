package com.smoothstack.utopia.entities;

import com.smoothstack.utopia.ids.BookingGuestId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

/**
 * Class representing BookingGuest data in the database.
 *
 * @author matthew.crowell
 */
@Entity
@IdClass(BookingGuestId.class)
public class BookingGuest {
	@Id
	private int bookingId;
	@Id
	private String contactEmail;
	@Id
	private String contactPhone;

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
	 * Get guest's contact email.
	 *
	 * @return String contact email
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * Set guest's contact email.
	 *
	 * @param contactEmail String contact email
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * Get guest's contact phone number.
	 *
	 * @return String phone number
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * Set guest's contact phone number.
	 *
	 * @param contactPhone String phone number
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BookingGuest that = (BookingGuest) o;
		return bookingId == that.bookingId && Objects.equals(contactEmail, that.contactEmail) && Objects.equals(contactPhone, that.contactPhone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, contactEmail, contactPhone);
	}

	@Override
	public String toString() {
		return "BookingGuest{" +
				"bookingId=" + bookingId +
				", contactEmail='" + contactEmail + '\'' +
				", contactPhone='" + contactPhone + '\'' +
				'}';
	}
}
