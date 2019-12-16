package com.cafimanager.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
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
import com.cafimanager.serviceImp.RoleServiceImpl;
import com.cafimanager.serviceImp.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@Autowired
	private SessionRegistry sessionRegistry;

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			User user = userServiceImpl.findByEmail(auth.getName());
			if (user != null) {
				return "redirect:/home";
			}
			return "login";
		}
		return "login";
	}

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userServiceImpl.findByEmail(auth.getName());
		Role role = user.getRole();
		session.setAttribute("role",role.getRole());
		session.setAttribute("user",user.getName());		
		
		if(role.getRole().equals("ADMIN")) {
			return "redirect:/admin/home";
		}
		if(role.getRole().equals("CLIENT")) {
			return "redirect:/client/home";
		}
		if(role.getRole().equals("CAISSIER")) {
			return "redirect:/caissier/home";
		}
		return "login";
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String homeAdmin(HttpSession session, Model model) {
		return "admin/home";
	}
	
	@RequestMapping(value = "/client/home", method = RequestMethod.GET)
	public String homeClient(HttpSession session, Model model) {
		return "client/home";
	}

	@RequestMapping(value = "/caissier/home", method = RequestMethod.GET)
	public String homeCaissier(HttpSession session, Model model) {
		return "caissier/home";
	}
	
	@RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
	public String invalidSession(HttpSession session, Model model) {
		return "error/invalidsession";
	}
	
	

}