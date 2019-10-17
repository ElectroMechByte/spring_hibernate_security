package com.training.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.model.BillingAddress;
import com.training.model.Customer;
import com.training.model.ShippingAddress;
import com.training.model.User;
import com.training.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class UserController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	@Autowired
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(value = "/registration")
	public String getRegistrationForm( Model model) {
		Customer customer = new Customer();
		User user = new User();
		BillingAddress ba = new BillingAddress();
		ShippingAddress sa = new ShippingAddress();
		customer.setShippingAddress(sa);
		customer.setBillingAddress(ba);
		customer.setUsers(user);
		model.addAttribute("data", customer);

		return "register";
	}

	// to insert the data
	@PostMapping(value = "/register")
	public String registerCustomer(@ModelAttribute("data")Customer customer,Model model, BindingResult result) throws IOException {
		 
		customerService.addCustomer(customer);
		return "login";
	}
}
