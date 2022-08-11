package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import com.example.exception.CustomerException;
import com.example.repository.CustomerRepository;
import com.example.validator.Validator;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomer(CustomerDTO customerDTO) throws CustomerException {
		Validator.validate(customerDTO);
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setName(customerDTO.getName());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customerRepository.save(customer);
	}

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customerSearched = optional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customerSearched.getCustomerId());
		customerDTO.setName(customerSearched.getName());
		customerDTO.setEmailId(customerSearched.getEmailId());
		customerDTO.setDateOfBirth(customerSearched.getDateOfBirth());
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> findAll() throws CustomerException {
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		Iterable<Customer> customerList = customerRepository.findAll();
		for (Customer customer : customerList) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setName(customer.getName());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTOList.add(customerDTO);
		}
		if (customerDTOList.isEmpty()) {
			throw new CustomerException("Service.CUSTOMERS_NOT_FOUND");
		}

		return customerDTOList;
	}

	@Override
	public void updateCustomer(Integer customerId, String emailId) throws CustomerException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customerSearched = optional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		customerSearched.setEmailId(emailId);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customerSearched = optional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(customerId);
	}

	@Override
	public CustomerDTO getCustomerByEmailId(String emailId) throws CustomerException {

		Optional<Customer> optional = customerRepository.findByEmailId(emailId);
		Customer customer=optional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		return customerDTO;
	}

	@Override
	public Iterable<CustomerDTO> getCustomerByName(String name) throws CustomerException {
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		Iterable<Customer> customerList = customerRepository.findByName(name);
		for (Customer customer : customerList) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setName(customer.getName());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTOList.add(customerDTO);
		}
		if (customerDTOList.isEmpty()) {
			throw new CustomerException("Service.CUSTOMERS_NOT_FOUND");
		}

		return customerDTOList;
	}

	@Override
	public List<CustomerDTO> findAllSortedOnName() throws CustomerException {
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		Sort sort=Sort.by("name");
		Iterable<Customer> customerList = customerRepository.findAll(sort);
		for (Customer customer : customerList) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setName(customer.getName());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTOList.add(customerDTO);
		}
		if (customerDTOList.isEmpty()) {
			throw new CustomerException("Service.CUSTOMERS_NOT_FOUND");
		}

		return customerDTOList;
	}

	@Override
	public List<CustomerDTO> findAllSortedOnNameDesc() throws CustomerException {
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		Sort sort=Sort.by("name").descending();
		Iterable<Customer> customerList = customerRepository.findAll(sort);
		for (Customer customer : customerList) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setName(customer.getName());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTOList.add(customerDTO);
		}
		if (customerDTOList.isEmpty()) {
			throw new CustomerException("Service.CUSTOMERS_NOT_FOUND");
		}

		return customerDTOList;
	}

       public List<CustomerDTO> page(int pageNo, int records) {
		// STEP1 We have to create an Object of Pageable ( which means an object of a class
		// which has implemented the Pageable Interface and the class is PageRequest
		Pageable pageable=PageRequest.of(pageNo,records);
		// STEP2 We have to create an object of Page which will be returned by findAll method
		//of repository
		Page<Customer> page=customerRepository.findAll(pageable);
		// STEP3 through page object we will invoke getContent method which will return a List of Customers
		List<Customer> customers=page.getContent();
	    List<CustomerDTO> customerDTOs=new ArrayList<>();
	    
		customers.forEach(customer->{
	    	CustomerDTO customerDTO=new CustomerDTO();
	    	customerDTO.setCustomerId(customer.getCustomerId());
	    	customerDTO.setName(customer.getName());
	    	customerDTO.setEmailId(customer.getEmailId());
	    	customerDTO.setDateOfBirth(customer.getDateOfBirth());	
	    	customerDTOs.add(customerDTO);
	    });
	 return customerDTOs;
	}

}
