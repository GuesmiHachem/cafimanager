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

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private SessionRegistry sessionRegistry;

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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			User user = userRepository.findByEmail(auth.getName());
			if(user!=null) {
			Role role = user.getRole();
			session.setAttribute("role",role.getRole());
			session.setAttribute("user",user.getName());	
			}
		}		
		
		List<Object> principals = sessionRegistry.getAllPrincipals();

		List<User> usersNamesList = new ArrayList<>();

		for (Object principal: principals) {
			
		    if (principal instanceof User) {
		    	User u=(User) principal;
		    	List<SessionInformation> activeUserSessions = new ArrayList<SessionInformation>();
		    	activeUserSessions=sessionRegistry.getAllSessions(principal,false); 
		    	// Should not return null;
		    	System.out.println(" activeUserSessions.size() :"+activeUserSessions.size());
		    	
		    	if (activeUserSessions.size()>0) {
                   usersNamesList.add(u);
                }
		    	
		    }
			
		}
		System.out.println(" principals.size() :"+principals.size());
		System.out.println(" usersNamesList.size() :"+usersNamesList.size());
		
		model.addAttribute("usersNamesList", usersNamesList);
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