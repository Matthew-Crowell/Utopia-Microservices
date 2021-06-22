package com.smoothstack.utopia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Class representing UserRole data in the database.
 *
 * @author matthew.crowell
 */
@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	/**
	 * Get role id.
	 *
	 * @return int user role id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set role id.
	 *
	 * @param id int user role id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get role name.
	 *
	 * @return String user role name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set role name.
	 *
	 * @param name String user role name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserRole userRole = (UserRole) o;
		return id == userRole.id && Objects.equals(name, userRole.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "UserRole{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
