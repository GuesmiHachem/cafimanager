package com.cafimanager.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.model.Ville;
import com.cafimanager.repository.DelegationRepository;
import com.cafimanager.repository.GovernoratRepository;
import com.cafimanager.repository.VilleRepository;
import com.cafimanager.service.VilleServiceImp;

@Controller
@RequestMapping("/admin/ville")
public class VilleController {

	
	@Autowired
	public DelegationRepository delegationRepository;
	@Autowired
	public GovernoratRepository governoratRepository;

	@Autowired
	public VilleServiceImp villeServiceImp;
	
	@RequestMapping({ "", "/" })
	public String findall(Model model, @RequestParam(name="page", defaultValue="0") int page , @RequestParam(name="size", defaultValue="4") int size) {
		List<Ville> villes = villeServiceImp.findAll();
		List<Delegation> delegations = delegationRepository.findAll();
		List<Governorat> governorats = governoratRepository.findAll();
		
		Ville ville = new Ville();
		
		Page<Ville> pageVilles = villeServiceImp.findAll(page, size, Sort.by("id"));
		int[] pages = new int [pageVilles.getTotalPages()];
				
		model.addAttribute("ville", ville);
		model.addAttribute("villes", villes);
		model.addAttribute("delegations", delegations);
		model.addAttribute("governorats", governorats);
		model.addAttribute("pageVilles", pageVilles.getContent());
		model.addAttribute("pages", pages);
		

		return "admin/ville";

	}

	@RequestMapping("/{id}")
	public String find(@PathVariable("id") String idString, Model model) {
		long id;
		try {
			if (idString != null) {
				return "redirect:/admin/ville";
			}
			id = Long.parseLong(idString);
			Ville ville = villeServiceImp.findById(id);
			if (ville != null) {
				model.addAttribute("ville", ville);
				List<Ville> villes = villeServiceImp.findAll();
				List<Delegation> delegations = delegationRepository.findAll();
				List<Governorat> governorats = governoratRepository.findAll();
				model.addAttribute("villes", villes);
				model.addAttribute("delegations", delegations);
				model.addAttribute("governorats", governorats);
				return "admin/ville";
			} else {
				return "redirect:/admin/ville";
			}

		} catch (Exception e) {
			return "redirect:/admin/ville";
		}

	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String add(Model model, @Valid Ville ville, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "redirect:/admin/ville";
		}
		villeServiceImp.create(ville);
		return "redirect:/admin/ville";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String idString, Model model) {

		long id;
		try {
			if (idString != null) {
				return "redirect:/admin/ville";
			}
			id = Long.parseLong(idString);
			Ville ville = villeServiceImp.findById(id);
			if (ville != null) {
				villeServiceImp.deleteById(id);
				return "redirect:/admin/ville";
			} else {
				return "redirect:/admin/ville";
			}

		} catch (Exception e) {
			return "redirect:/admin/ville";
		}
	}

}
