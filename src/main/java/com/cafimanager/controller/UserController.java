package com.cafimanager.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.model.Role;
import com.cafimanager.model.User;
import com.cafimanager.model.Ville;
import com.cafimanager.repository.RoleRepository;
import com.cafimanager.repository.UserRepository;
import com.cafimanager.serviceImp.RoleServiceImpl;
import com.cafimanager.serviceImp.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@Autowired
	private SessionRegistry sessionRegistry;
    
	
	private List<User> users;
	private User user;
	public Page<User> pageUsers;
	public int[] pages;
	public long id;
	
	@RequestMapping(value = { "/admin/addAdmin"}, method = RequestMethod.GET)
	public String addAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		return "/admin/add-admin";
	}

	@RequestMapping(value = "/admin/addAdmin", method = RequestMethod.POST)
	public ModelAndView addAdmin(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userServiceImpl.findByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "Email has already been taken" + " Check your details!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			Role userRole = roleServiceImpl.findByRole("ADMIN");
			userServiceImpl.create(user, userRole);
			
			modelAndView.addObject("successMessage", "Registration Successful.");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("redirect:/admin/addAdmin");
		}
		return modelAndView;
	}
	
	

	@RequestMapping(value = "/admin/listuser", method = RequestMethod.GET)
	public String listUser(Model model, @RequestParam(name="page", defaultValue="0") int page , @RequestParam(name="size", defaultValue="4") int size) {
		pageUsers = userServiceImpl.findAll(page, size, Sort.by("id"));
		pages = new int [pageUsers.getTotalPages()];		
		model.addAttribute("pageUsers", pageUsers.getContent());
		model.addAttribute("pages", pages);
		return "admin/list-user";
	}


}