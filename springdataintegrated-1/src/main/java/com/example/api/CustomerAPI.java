package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerDTO;
import com.example.dto.PassportDTO;
import com.example.exception.CustomerException;
import com.example.service.CustomerService;

// http://localhost:9090/xyzcompany
@RestController
@RequestMapping("/xyzcompany")
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Environment environment;

	// GET--->// http://localhost:4545/xyzcompany/customers/1

	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") int customerId) throws CustomerException {

		CustomerDTO customerDTO = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);

	}
	// POST--->// http://localhost:4545/xyzcompany/customers

	@PostMapping("/customers")
	public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO) throws CustomerException {
		customerService.addCustomer(customerDTO);
		String message = environment.getProperty("Controller.INSERT_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

// DELETE-----> http://localhost:4545/xyzcompany/customers/4     
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int customerId) throws CustomerException {
		customerService.deleteCustomer(customerId);
		String message = environment.getProperty("Controller.DELETE_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

// PUT------>http://localhost:4545/xyzcompany/customers/2  
	@PutMapping("/customers/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable("id") Integer customerId,	@RequestBody PassportDTO passportDTO) throws CustomerException {
		customerService.updateCustomerPassport(customerId, passportDTO);
		String message = environment.getProperty("Controller.UPDATE_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// GET------->// http://localhost:4545/xyzcompany/customers
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> getCustomers() throws CustomerException {
		List<CustomerDTO> customerDTOList = customerService.findAll();
		return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
	}

	

	

}
