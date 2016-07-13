package com.scalefocus.edu.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.scalefocus.edu.db.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>{
	Client getByClientIdOrEmail(String clientId, String email);
}
