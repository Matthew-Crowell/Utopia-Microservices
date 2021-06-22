package com.smoothstack.utopia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Class representing GuestBooking data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class GuestBooking {
	@Id
	private int id;
	private boolean isActive;
	private String confirmationCode;
	private String contactEmail;
	private String contactPhone;
	private int agentId;

	/**
	 * Get guest booking id.
	 *
	 * @return int guest booking id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set guest booking id.
	 *
	 * @param id int guest booking id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get status of guest booking.
	 *
	 * @return boolean true if active, false if not active
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * Set status of guest booking.
	 *
	 * @param isActive boolean true if active, false if not active
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Get confirmation code for guest booking.
	 *
	 * @return String confirmation code
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * Set confirmation code for guest booking.
	 *
	 * @param confirmationCode String confirmation code
	 */
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	/**
	 * Get contact email for guest who booked.
	 *
	 * @return String email address
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * Set contact email address for guest who booked reservation.
	 *
	 * @param contactEmail String email address
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * Get contact phone number for guest who booked reservation.
	 *
	 * @return String phone number
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * Set contact phone number for guest who booked reservation.
	 *
	 * @param contactPhone String phone number
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * Get associated agent id.
	 *
	 * @return int id of agent associated with guest booking
	 */
	public int getAgentId() {
		return agentId;
	}

	/**
	 * Set agent id associated with this booking.
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
		GuestBooking that = (GuestBooking) o;
		return id == that.id && isActive == that.isActive && agentId == that.agentId && Objects.equals(confirmationCode, that.confirmationCode) && Objects.equals(contactEmail, that.contactEmail) && Objects.equals(contactPhone, that.contactPhone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isActive, confirmationCode, contactEmail, contactPhone, agentId);
	}

	@Override
	public String toString() {
		return "GuestBooking{" +
				"id=" + id +
				", isActive=" + isActive +
				", confirmationCode='" + confirmationCode + '\'' +
				", contactEmail='" + contactEmail + '\'' +
				", contactPhone='" + contactPhone + '\'' +
				", agentId=" + agentId +
				'}';
	}
}
