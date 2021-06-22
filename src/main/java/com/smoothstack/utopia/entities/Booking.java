package com.smoothstack.utopia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Class representing Booking data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean isActive;
	private String confirmationCode;

	/**
	 * Get booking id.
	 *
	 * @return int booking id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set booking id.
	 *
	 * @param id int booking id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get status indicator.
	 *
	 * @return boolean true for active, false for not active
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * Set status indicator.
	 *
	 * @param isActive boolean true for active, false for inactive
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Get confirmation code.
	 *
	 * @return String confirmation code
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * Set confirmation code.
	 *
	 * @param confirmationCode String confirmation code
	 */
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Booking booking = (Booking) o;
		return id == booking.id && isActive == booking.isActive && Objects.equals(confirmationCode, booking.confirmationCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isActive, confirmationCode);
	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", isActive=" + isActive +
				", confirmationCode='" + confirmationCode + '\'' +
				'}';
	}
}
