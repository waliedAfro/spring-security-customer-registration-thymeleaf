package com.afro.customer.service;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.afro.customer.model.Customer;
import com.afro.customer.model.MyUserDetails;
import com.afro.customer.repository.CustomerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private CustomerRepository customerRepository;

	public MyUserDetailsService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Customer> customer = customerRepository.findByMobile(username);

		customer.orElseThrow(() -> new UsernameNotFoundException("UserName or Password Not Valid"));
		
		return customer.map(MyUserDetails::new).get();
	}

}
