package com.lana_climat.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana_climat.entity.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
	
	
	//Consulta SQL de Usuario por documento
	public User findByDocumentNumber(String documentnumber);
}
