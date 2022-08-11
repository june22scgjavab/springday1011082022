package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.CustomerDTO;
import com.example.exception.CustomerException;


public interface CustomerService {

	public void addCustomer(CustomerDTO customer) throws CustomerException;
	public CustomerDTO getCustomer(Integer customerId) throws CustomerException;
	public List<CustomerDTO> findAll() throws CustomerException;
	public void updateCustomer(Integer customerId, String emailId) throws CustomerException;
	public void deleteCustomer(Integer customerId)throws CustomerException;
	public CustomerDTO getCustomerByEmailId(String emailId) throws CustomerException;
	public Iterable<CustomerDTO> getCustomerByName(String name) throws CustomerException;
	public List<CustomerDTO> findAllSortedOnName() throws CustomerException;
	public List<CustomerDTO> findAllSortedOnNameDesc() throws CustomerException;
	public List<CustomerDTO> page(int pageNo, int records);
	
}
