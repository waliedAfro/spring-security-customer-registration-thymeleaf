package com.afro.customer.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.afro.customer.dto.CustomerDTO;
import com.afro.customer.model.Customer;
import com.afro.customer.model.Role;
import com.afro.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private BCryptPasswordEncoder getBCryptPasswordEncoder;  
	// inject BCryptPasswordEncoder Bean in encode password
	
	private CustomerRepository customerRepository ; 
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public Customer saveCustomer(CustomerDTO dto) {
	
		
		
		return customerRepository.save(
				new Customer(dto.getFirstName(),
						dto.getSurname(),
						dto.getMobile(),
						getBCryptPasswordEncoder.encode(dto.getPassword()),
						dto.getGender(),
						Arrays.asList(new Role("USER")))) ;
	}

}
