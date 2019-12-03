package com.cafimanager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
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

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			User user = userRepository.findByEmail(auth.getName());
			if (user != null) {
				return "redirect:/home";
			}
			return "login1";
		}

		return "login1";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
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
			bindingResult.rejectValue("email", "error.user", "Email has already been taken" + " Check your details!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userRepository.save(user);

			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(1);
			//Role userRole = roleRepository.findByRole("ADMIN");
			//user.setRole(userRole);
			userRepository.save(user);

			modelAndView.addObject("successMessage", "Registration Successful.");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/access-denied", method = RequestMethod.GET) public
	 * ModelAndView test() { ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("403"); return modelAndView; }
	 * 
	 */

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {


		/*
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

		List<org.springframework.security.core.userdetails.User> usersNamesList = new ArrayList<>();

		for (Object principal: principals) {
			
		    if (principal instanceof org.springframework.security.core.userdetails.User) {
		    	org.springframework.security.core.userdetails.User u=(org.springframework.security.core.userdetails.User) principal;
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
		*/
		
		return "home";
	}

	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getLogedUser", method = RequestMethod.GET)
	public String getLogedUser(HttpSession session, Model model) {
		List<String> roles = new ArrayList<>();
		SecurityContext securitycontext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		for (GrantedAuthority ga : securitycontext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		model.addAttribute("roles", roles);
		return "d";
	}
	/**
	 * Lorsque la session est invalide 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
	public String invalidSession(HttpSession session, Model model) {
		return "invalidsession";
	}


}