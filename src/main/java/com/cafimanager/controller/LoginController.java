package com.cafimanager.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cafimanager.model.Role;
import com.cafimanager.model.User;
import com.cafimanager.repository.RoleRepository;
import com.cafimanager.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	/**
	 * @RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	 * @return
	 */
	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			User user = userRepository.findByEmail(auth.getName());
			if (user != null) {
				return "redirect:/home";
			}
			return "login";
		}
		return "login";
	}

	/**
	 * @RequestMapping(value = "/registration", method = RequestMethod.GET)
	 * @return
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	/**
	 * @RequestMapping(value = "/registration", method = RequestMethod.POST)
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userRepository.findByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "Email has already been taken" + " Check your details!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(1);
			Role userRole = roleRepository.findByRole("ADMIN");
			user.setRole(userRole);
			userRepository.save(user);
			modelAndView.addObject("successMessage", "Registration Successful.");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}

	
	/**
	 * @RequestMapping(value = "/home", method = RequestMethod.GET)
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		return "home";
	}


	/**
	 * @RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
	public String invalidSession(HttpSession session, Model model) {
		return "invalidsession";
	}
	
	@RequestMapping(value = "/page123", method = RequestMethod.GET)
	public String page(HttpSession session, Model model) {
		return "page";
	}

}