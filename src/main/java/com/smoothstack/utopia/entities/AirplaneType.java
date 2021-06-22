package com.smoothstack.utopia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Class representing AirplaneType data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class AirplaneType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int maxCapacity;

	/**
	 * Get airplane type id.
	 *
	 * @return int airplane type id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set airplane type id.
	 *
	 * @param id int airplane type id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get maximum passenger capacity for this airplane type.
	 *
	 * @return int maximum passenger capacity
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * Set maximum passenger capacity for this airplane type.
	 *
	 * @param maxCapacity int maximum passenger capacity
	 */
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AirplaneType that = (AirplaneType) o;
		return id == that.id && maxCapacity == that.maxCapacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, maxCapacity);
	}

	@Override
	public String toString() {
		return "AirplaneType{" +
				"id=" + id +
				", maxCapacity=" + maxCapacity +
				'}';
	}
}
