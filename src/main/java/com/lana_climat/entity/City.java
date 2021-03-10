package com.lana_climat.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the citys database table.
 * 
 */
@Entity
@Table(name = "citys")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "citys_seq_generator")
	@SequenceGenerator(name = "citys_seq_generator", sequenceName = "public.citys_id_seq", allocationSize = 1)
	private Long id;

	private String name;

	// bi-directional many-to-one association to Registry
	@OneToMany(mappedBy = "city")
	private List<Registry> registries;

	public City() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Registry> getRegistries() {
		return this.registries;
	}

	public void setRegistries(List<Registry> registries) {
		this.registries = registries;
	}

	public Registry addRegistry(Registry registry) {
		getRegistries().add(registry);
		registry.setCity(this);

		return registry;
	}

	public Registry removeRegistry(Registry registry) {
		getRegistries().remove(registry);
		registry.setCity(null);

		return registry;
	}

}