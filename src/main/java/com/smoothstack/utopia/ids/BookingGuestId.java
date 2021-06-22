package com.smoothstack.utopia.ids;

import java.util.Objects;

/**
 * Composite id key for BookingGuest entity.
 *
 * @author matthew.crowell
 */
public class BookingGuestId implements java.io.Serializable {
	int bookingId;
	String contactEmail;
	String contactPhone;

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
	 * @return String email address
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * Set guest's contact email.
	 *
	 * @param contactEmail email address
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
	public String toString() {
		return "BookingGuestId{" +
				"bookingId=" + bookingId +
				", contactEmail='" + contactEmail + '\'' +
				", contactPhone='" + contactPhone + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BookingGuestId that = (BookingGuestId) o;
		return bookingId == that.bookingId && Objects.equals(contactEmail, that.contactEmail) && Objects.equals(contactPhone, that.contactPhone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, contactEmail, contactPhone);
	}
}
