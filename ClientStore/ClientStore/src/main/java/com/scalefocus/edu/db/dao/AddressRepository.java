package com.scalefocus.edu.db.dao;

import org.springframework.data.repository.CrudRepository;
import com.scalefocus.edu.db.model.Address;

public interface AddressRepository extends CrudRepository<Address, String>{
}
