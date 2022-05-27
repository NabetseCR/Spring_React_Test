package com.esteban.cardatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Json Ignore and Properties annotations work to avoid a loop
// this will occur when a one to many relationship.
// The parent entity is serialized, and it contains the child entity when is also serialized

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerid;
	private String firstname, lastname;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	List<Car> cars;
	
	public Owner() {}
	public Owner(String firstname, String lastname) {
		super();
		this.setFirstname(firstname);
		this.setLastname(lastname);
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public long ownerid() {
		return ownerid;
	}
	public List<Car> getCars(){
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
