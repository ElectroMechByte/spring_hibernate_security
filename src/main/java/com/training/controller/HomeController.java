package com.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping({ "/index", "/index1" })
	public String sayIndex() {
		return "index1";
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("hello", "hello", "Hello Mr.Ismail");
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("error", "Invalid username and Password");
		if (logout != null)
			model.addAttribute("logout", "You have logged out successfully");
		return "login";
	}

	@RequestMapping("/aboutus")
	public String sayAbout() {
		return "aboutUs";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(HttpSession session, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return  "aboutUs";
		
		
	}

	/*
	 * @Autowired private QueriesService queryService;
	 * 
	 * @RequestMapping(value = "/contactus") public ModelAndView getQuery() {
	 * Queries query = new Queries(); return new ModelAndView("contactUs",
	 * "contact", query); }
	 * 
	 * @RequestMapping(value = "/contactus", method = RequestMethod.POST) public
	 * String addQuery(@Valid @ModelAttribute(value = "contact") Queries query,
	 * Model model, BindingResult result) {
	 * 
	 * if (result.hasErrors()) return "contactUs";
	 * 
	 * queryService.addQuery(query); model.addAttribute("querySuccess",
	 * "Thank you, Your Message stored in our Server we will contact through corresponding Mail"
	 * ); return "login";
	 * 
	 * }
	 */
}
