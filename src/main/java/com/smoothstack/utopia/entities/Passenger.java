package com.smoothstack.utopia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * Class representing Passenger data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int bookingId;
	private String givenName;
	private String familyName;
	private Date dob;
	private String gender;
	private String address;

	/**
	 * Get passenger id.
	 *
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set passenger id.
	 *
	 * @param id int id
	 */
	public void setId(int id) {
		this.id = id;
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

	/**
	 * Get passenger's given name.
	 *
	 * @return String given name
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * Set passenger's given name.
	 *
	 * @param givenName String given name
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * Get passenger's family name.
	 *
	 * @return String passenger's family name
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * Set passenger's family name.
	 *
	 * @param familyName String family name
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * Get passenger's date of birth.
	 *
	 * @return Date date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Set passenger's date of birth
	 *
	 * @param dob Date date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Get passenger's gender.
	 *
	 * @return String passenger's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set passenger's gender.
	 *
	 * @param gender String passenger's gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get passenger's address.
	 *
	 * @return String passenger's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set passenger's address.
	 *
	 * @param address String passenger's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Passenger passenger = (Passenger) o;
		return id == passenger.id && bookingId == passenger.bookingId && Objects.equals(givenName, passenger.givenName) && Objects.equals(familyName, passenger.familyName) && Objects.equals(dob, passenger.dob) && Objects.equals(gender, passenger.gender) && Objects.equals(address, passenger.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, bookingId, givenName, familyName, dob, gender, address);
	}

	@Override
	public String toString() {
		return "Passenger{" +
				"id=" + id +
				", bookingId=" + bookingId +
				", givenName='" + givenName + '\'' +
				", familyName='" + familyName + '\'' +
				", dob=" + dob +
				", gender='" + gender + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
