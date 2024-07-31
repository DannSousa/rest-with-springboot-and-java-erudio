package com.example.model;

import java.io.Serializable;
import java.util.Objects;
public class Person implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String firtsName;
	private String lastName;
	private String addres;
	private String gender;

	public Person() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirtsName() {
		return firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addres, firtsName, gender, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(addres, other.addres) && Objects.equals(firtsName, other.firtsName)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(lastName, other.lastName);
	}
	
	
}
