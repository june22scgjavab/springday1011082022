package com.example.validator;

import java.time.LocalDate;

import com.example.dto.CustomerDTO;
import com.example.exception.CustomerException;


public class Validator {

	
	public static void validate(CustomerDTO customerDTO) throws CustomerException
	{
		String message=null;
		if(!validateCustomerId(customerDTO.getCustomerId()))
		{
			message="Validator.INVALID_ID";
		}
		if(!validateCustomerEmail(customerDTO.getEmailId()))
		{
			message="Validator.INVALID_EMAIL";
		}
		if(!validateCustomerName(customerDTO.getName()))
		{
			message="Validator.INVALID_NAME";
		}
		
		if(!validateCustomerDOB(customerDTO.getDateOfBirth()))
		{
			message="Validator.INVALID_DOB";
		}
	 if(message!=null) {
		 throw new CustomerException(message);
	 }
	
	}

	private static boolean validateCustomerDOB(LocalDate dateOfBirth) {
		
		return dateOfBirth.isBefore(LocalDate.now()) ? true : false;
	}
	
	// Here we can have two words which is first name and last name
	// Or we can have firstname middlename and lastname
	// () is used for grouping .
	// The first group ([A-Z][a-z]+) means the firstname should start with uppercase followed by atleast
	// one smallcase character 
	// In the second group (\\s[A-Z][a-z]+) means that it should be having a space followed by an
	// uppercase character and after that one or more smallcase character
	// {1,2} means the (\\s[A-Z][a-z]+){ can be once matched or at the most twice, which means
	// either I can have lastname or middlename and lastname

	private static boolean validateCustomerName(String name) {
		
		return name.matches("^([A-Z][a-z]+)(\\s[A-Z][a-z]+){1,2}$") ? true : false;
				
	}
 // In the following regular expression:
	// email should not start with a digit
	// The first part of email before @ can have digits and characters
	// after @ we want the pattern infy
	// followed by that . ( dot is accompanied with \ as dot is having a usage in regular expression
	// to substitute single character but here we want exactly the . in the string. So we are prefixing
	// . with \ but \ is used with \n \t which are escape characters. So one extra \ is used with \ to
	// negate its special purpose.
	// So ultimately \\. means we are looking for . in the String
	//^ is used for start of string
	// $ at the end means looking for a pattern at the end
	// using both means we are looking an exact pattern which will match a string
	// ^ inside [] means not so ^[^0-9] means the pattern which we are searching for should not start with
	// a digit
	private static boolean validateCustomerEmail(String emailId) {
		return emailId.matches("^[^0-9][a-z0-9]+@infy\\.com$") ? true : false;
	}

	private static boolean validateCustomerId(int customerId) {
		
		return customerId<=0?false : true;
	}
}
