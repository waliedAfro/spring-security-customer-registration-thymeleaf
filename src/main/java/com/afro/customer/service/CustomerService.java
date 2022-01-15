package com.afro.customer.service;

import com.afro.customer.dto.CustomerDTO;
import com.afro.customer.model.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(CustomerDTO dto);

}
