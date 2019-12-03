package com.cafimanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafimanager.model.Cafe;
import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.model.User;
import com.cafimanager.model.Ville;
import com.cafimanager.repository.CafeRepository;
import com.cafimanager.repository.GovernoratRepository;
import com.cafimanager.repository.UserRepository;


@Controller
@RequestMapping("/client")
public class CafeController {

	@Autowired
	public CafeRepository cafeRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	
	@RequestMapping("/cafe")
	public String findall(Model model) {
		List<Cafe> cafes = cafeRepository.findAll();
		model.addAttribute("cafes", cafes);
		return "client/cafe";

	}


	@RequestMapping("/{id}")
	public String find(@PathVariable("id") String idString,Model model) {
		
		try {
			//long id;
			//id = Long.parseLong(idString);
			//Optional<User> userOptional=userRepository.findById(1l);
			//User user=userOptional.get();
			//user=user.get();
			//List<Cafe> listcafes=cafeRepository.findAllByUser(user);
			//model.addAttribute("listcafes", listcafes);
			//model.addAttribute("user", user);
			model.addAttribute("user1", "ss");
			
		} catch (Exception e) {
			// System.out.println("Je ne suis pas un entier, et alors ca te derange ?");
			return "client/produit";
		}
		return "client/cafe";

	}

	

}
