package com.example.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
	@Query("select c from Customer c where c.emailId=:emailId")
	Optional<Customer> findByEmailId(@Param("emailId") String emailId);

	@Query("select c from Customer c where c.name=?1")
	Iterable<Customer> findByName(String name);
	
	
	
}
