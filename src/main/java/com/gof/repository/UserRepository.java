package com.gof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gof.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}