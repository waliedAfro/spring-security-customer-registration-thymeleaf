package com.afro.customer.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityControler {

	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
}
