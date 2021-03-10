package com.lana_climat.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the registry database table.
 * 
 */
@Entity
public class Registry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "registry_seq_generator")
	@SequenceGenerator(name = "registry_seq_generator", sequenceName = "public.registry_id_seq", allocationSize = 1)
	private Long id;

	private BigDecimal humidity;

	private BigDecimal temperature;

	// bi-directional many-to-one association to City
	@ManyToOne
	private City city;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Registry() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getHumidity() {
		return this.humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTemperature() {
		return this.temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}