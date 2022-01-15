package com.afro.customer.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = { @UniqueConstraint(name = "UNQ_CUSTOMER", columnNames = { "mobile" }) })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cutomerId;
	private String firstName;
	private String surname;
	private String mobile;
	private String password;
	private String gender;

	public Customer() {

	}

	public Customer(String firstName, String surname, String mobile, String password, String gender,
			Collection<Role> roles) {

		this.firstName = firstName;
		this.surname = surname;
		this.mobile = mobile;
		this.password = password;
		this.gender = gender;
		this.roles = roles;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_role", joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "cutomerId"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
	private Collection<Role> roles;

	public Long getCutomerId() {
		return cutomerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPassword() {
		return password;
	}

	public String getGender() {
		return gender;
	}

	public void setCutomerId(Long cutomerId) {
		this.cutomerId = cutomerId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
