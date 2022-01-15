package com.afro.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afro.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//no need to Annotate interface by  @Reposity because  spring boot will take care of it 
	// JpaRepository will provide many method out of the box 
	//for more information check spring website  
	// we added custom method we will use it in login processing 
	public Optional<Customer> findByMobile(String mobile);

}
