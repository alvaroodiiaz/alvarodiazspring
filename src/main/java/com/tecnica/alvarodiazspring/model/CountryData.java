package com.tecnica.alvarodiazspring.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class CountryData implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country", unique=false,nullable=false)
	private String country;

	@Column(name="population", unique=false,nullable=false)
	private long population;

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
}