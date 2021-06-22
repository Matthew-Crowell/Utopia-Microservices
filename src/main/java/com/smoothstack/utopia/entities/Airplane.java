package com.smoothstack.utopia.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class representing Airplane data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private AirplaneType type;

	/**
	 * Get airplane id.
	 *
	 * @return int airplane id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set airplane id.
	 *
	 * @param id int airplane id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get airplane type.
	 *
	 * @return AirplaneType airplane type
	 */
	public AirplaneType getType() {
		return type;
	}

	/**
	 * Set airplane type.
	 *
	 * @param type AirplaneType airplane type
	 */
	public void setType(AirplaneType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Airplane airplane = (Airplane) o;
		return id == airplane.id && Objects.equals(type, airplane.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public String toString() {
		return "Airplane{" +
				"id=" + id +
				", type=" + type +
				'}';
	}
}
