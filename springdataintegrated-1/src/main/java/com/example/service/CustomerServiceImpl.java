package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.CustomerDTO;
import com.example.dto.PassportDTO;
import com.example.entity.Customer;
import com.example.entity.Passport;
import com.example.exception.CustomerException;
import com.example.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomer(CustomerDTO customerDTO) throws CustomerException {
		// Validator.validate(customerDTO);

		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setName(customerDTO.getName());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		PassportDTO passportDTO = customerDTO.getPassportDTO();
		Passport passport = new Passport();
		passport.setId(passportDTO.getId());
		passport.setDateOfIssue(passport.getDateOfIssue());
		passport.setDateOfExpiry(passportDTO.getDateOfExpiry());
		customerRepository.save(customer);
	}

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws CustomerException {

		Optional<Customer> customerSearched = customerRepository.findById(customerId);
		Customer customer = customerSearched.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));

		CustomerDTO customerDTO = new CustomerDTO();
		PassportDTO passportDTO = new PassportDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		Passport passport = customer.getPassport();
		passportDTO.setId(passport.getId());
		passportDTO.setDateOfIssue(passport.getDateOfIssue());
		passportDTO.setDateOfExpiry(passport.getDateOfExpiry());
		customerDTO.setPassportDTO(passportDTO);
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> findAll() throws CustomerException {
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		Iterable<Customer> customerList = customerRepository.findAll();
		for (Customer customer : customerList) {
			CustomerDTO customerDTO = new CustomerDTO();
			PassportDTO passportDTO = new PassportDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setName(customer.getName());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			Passport passport = customer.getPassport();
			passportDTO.setId(passport.getId());
			passportDTO.setDateOfIssue(passport.getDateOfIssue());
			passportDTO.setDateOfExpiry(passport.getDateOfExpiry());
			customerDTO.setPassportDTO(passportDTO);
			customerDTOList.add(customerDTO);
		}
		if (customerDTOList.isEmpty()) {
			throw new CustomerException("Service.CUSTOMERS_NOT_FOUND");
		}

		return customerDTOList;
	}

	@Override
	public void updateCustomerPassport(Integer customerId, PassportDTO passportDTO) throws CustomerException {
		Optional<Customer> customerSearched = customerRepository.findById(customerId);
		Customer customer = customerSearched.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		Passport passport = customer.getPassport();
		passport.setDateOfExpiry(passportDTO.getDateOfExpiry());
	}

	@Override
	public void deleteCustomer(Integer customerId) throws CustomerException {
		Customer customerSearched = customerRepository.findById(customerId).get();
		if (customerSearched == null) {
			throw new CustomerException("Service.CUSTOMER_NOT_FOUND");
		}
		customerRepository.deleteById(customerId);
	}

}
