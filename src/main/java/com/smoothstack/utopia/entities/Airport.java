package com.smoothstack.utopia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Class representing Airport data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class Airport {
	@Id
	private String iataId;
	private String city;

	/**
	 * Get iata code.
	 *
	 * @return String iataId
	 */
	public String getIataId() {
		return iataId;
	}

	/**
	 * Set iata code.
	 *
	 * @param iataID String iataId
	 */
	public void setIataId(String iataID) {
		this.iataId = iataID;
	}

	/**
	 * Get city.
	 *
	 * @return String city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set city.
	 *
	 * @param city String city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Airport airport = (Airport) o;
		return Objects.equals(iataId, airport.iataId) && Objects.equals(city, airport.city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(iataId, city);
	}

	@Override
	public String toString() {
		return "Airport{" +
				"iataId='" + iataId + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
