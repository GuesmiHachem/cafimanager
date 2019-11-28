package com.cafimanager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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



	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value={"/index"}, method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userRepository.findByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"Email has already been taken"
							+ " Check your details!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userRepository.save(user);
			modelAndView.addObject("successMessage", "Registration Successful.");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}


	@RequestMapping(value="/access-denied", method = RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("403");
		return modelAndView;
	}

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Role role = new Role();
		//Role role2 = new Role();
		role = roleRepository.findByRole("Admin");
		//role2 = roleRepository.findByRole("USER");
		List<User> users = new ArrayList<>();
		List<User> users2 = new ArrayList<>();
		users = userRepository.findByRole(role);
		//users2 = userRepository.findByRole(role2);
		
		
		
		/*
		List<Task> tasks = new ArrayList<>();
		tasks = taskService.findAll();
		int taskCount = tasks.size();
		int adminCount = users.size();
		int userCount = users2.size();
		modelAndView.addObject("adminCount", adminCount);//Authentication for NavBar
		modelAndView.addObject("userCount", userCount);//Authentication for NavBar
		modelAndView.addObject("taskCount", taskCount);//Authentication for NavBar
		//-----------------------------------------
		*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User loginUser = userRepository.findByEmail(auth.getName());
		modelAndView.addObject("control", loginUser.getRole().getRole());//Authentication for NavBar
		modelAndView.addObject("auth", loginUser);
		/*
		List<UserTask> userTasks = new ArrayList<>();
		userTasks = userTaskService.findByUser(loginUser);
		*/
		//modelAndView.addObject("userTaskSize", userTasks.size());
		modelAndView.setViewName("test");
		return modelAndView;
	}

}