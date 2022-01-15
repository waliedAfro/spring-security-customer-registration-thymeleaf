package com.afro.customer.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Customer customer;

	
	public MyUserDetails(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return getGrantedAuthority(customer.getRoles());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println("customer.getPassword() :" + customer.getPassword());
		return customer.getPassword();
		
		
	}

	@Override
	public String getUsername() {
		System.out.println("customer.getMobile() :" + customer.getMobile());
		return customer.getMobile();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; // just change to true hard code
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // just change to true hard code
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true; // just change to true hard code
	}

	@Override
	public boolean isEnabled() {

		return true; // just change to true hard code
	}

	// --------------------------------------------------------
	private List<GrantedAuthority> getGrantedAuthority(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

}
