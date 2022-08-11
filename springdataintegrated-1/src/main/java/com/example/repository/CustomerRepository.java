package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
}
