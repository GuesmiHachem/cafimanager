package com.cafimanager.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafimanager.model.Governorat;
import com.cafimanager.repository.GovernoratRepository;

@Controller
@RequestMapping("/governorat")
public class GovernoratController {

	@Autowired
	public  GovernoratRepository governoratRepository;
	
	@RequestMapping("/list")
	public String findall(Model model) {
		List<Governorat> governorats =governoratRepository.findAll();
		model.addAttribute("governorats",governorats);
		return "governorat";
		
	}
	
	@RequestMapping("/{id}")
	public String find(@PathVariable("id") Long id ,Model model) {
		
		Optional<Governorat> governoratopt = governoratRepository.findById(id);
		Governorat governorat= governoratopt.get();
		model.addAttribute("gov",governorat);
		return "governorat";
		
	}
}
