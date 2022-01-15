package com.afro.customer.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.afro.customer.dto.CustomerDTO;
import com.afro.customer.service.CustomerService;

@Controller
@RequestMapping("/registration")
public class CustomerController {

	//inject Customer service 
	private CustomerService customerService ;
	// there are two way to inject it's through @Autowaired or constructor 
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public String showCreateAccount(Model model)
	{
		//get request to show create account page 
		CustomerDTO customerDto = new CustomerDTO();
		model.addAttribute("customer",customerDto);
		return "createAccount" ;
	}
	
	@PostMapping
	public String createAccount(@ModelAttribute("customer") CustomerDTO customerDTO)
	{
		// post mapping to handle save customer data
		customerService.saveCustomer(customerDTO);
		return "redirect:/registration?success" ;
	}
	
	
}
