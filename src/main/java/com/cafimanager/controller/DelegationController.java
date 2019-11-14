package com.cafimanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.repository.DelegationRepository;

@Controller
@RequestMapping("/delegation")
public class DelegationController {

	@Autowired
	public  DelegationRepository delegationRepository;
	
	@RequestMapping("/list")
	public String findall(Model model) {
		List<Delegation> delegations =delegationRepository.findAll();
		model.addAttribute("delegations",delegations);
		return "delegation";
		
	}
	
	@RequestMapping("/{id}")
	public String find(@PathVariable("id") Long id ,Model model) {
		
		Optional<Delegation> delegationopt = delegationRepository.findById(id);
		Delegation delegation= delegationopt.get();
		model.addAttribute("delegation",delegation);
		return "delegation";
		
	}
}
