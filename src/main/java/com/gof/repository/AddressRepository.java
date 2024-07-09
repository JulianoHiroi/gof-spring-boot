package com.gof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gof.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}
