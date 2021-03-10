package com.lana_climat.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users", 
catalog = "LanaClimat",
schema = "public")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	
	//Secuencia del autoincrementable default de postgres
	@Id
    @GeneratedValue(
	            strategy = GenerationType.AUTO,
	            generator = "users_seq_generator")
	    @SequenceGenerator(
	            name = "users_seq_generator",
	            sequenceName = "public.users_id_seq",
	            allocationSize = 1)
	private Long id;

	@Column(name="document_number")
	private String documentNumber;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="surname")
	private String surname;
	
	@OneToMany(mappedBy="user")
	private List<Registry> registries;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Registry> getRegistries() {
		return this.registries;
	}

	public void setRegistries(List<Registry> registries) {
		this.registries = registries;
	}

	public Registry addRegistry(Registry registry) {
		getRegistries().add(registry);
		registry.setUser(this);

		return registry;
	}

	public Registry removeRegistry(Registry registry) {
		getRegistries().remove(registry);
		registry.setUser(null);

		return registry;
	}

	public User(String documentNumber, String name, String password, String surname, List<Registry> registries) {
		this.documentNumber = documentNumber;
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.registries = registries;
	}
}