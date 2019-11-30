package com.cafimanager.controller;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

@Controller
@RequestMapping("/admin/ville")
public class VilleController {

	@Autowired
	public VilleRepository villeRepository;
	@Autowired
	public DelegationRepository delegationRepository;
	@Autowired
	public GovernoratRepository governoratRepository;

	/*
	 * public List<Ville> villes = new ArrayList<Ville>(); public List<Delegation>
	 * delegations = new ArrayList<Delegation>(); public List<Governorat>
	 * governorats = new ArrayList<Governorat>(); public Ville ville; public
	 * Delegation delegation; public Governorat governorat; public Optional<Ville>
	 * v; public Optional<Delegation> d; public Optional<Governorat> g;
	 * 
	 */
	@RequestMapping({ "", "/" })
	public String findall(Model model, @RequestParam(name="page", defaultValue="0") int page , @RequestParam(name="size", defaultValue="4") int size) {
		List<Ville> villes = villeRepository.findAll();
		List<Delegation> delegations = delegationRepository.findAll();
		List<Governorat> governorats = governoratRepository.findAll();
		
		Ville ville = new Ville();
		
		Page<Ville> pageVilles = villeRepository.findAll(new PageRequest(page,size));
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

		try {
			long id;
			id = Long.parseLong(idString);
			Ville ville = villeRepository.findById(id);
			// ville = v.get();
			if (ville != null) {
				model.addAttribute("ville", ville);
				List<Ville> villes = villeRepository.findAll();
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
			// System.out.println("Je ne suis pas un entier, et alors ca te derange ?");
			return "redirect:/admin/ville";
		}

	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String add(Model model, @Valid Ville ville, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("villeadderror", "oui");
			List<Ville> villes = villeRepository.findAll();
			List<Delegation> delegations = delegationRepository.findAll();
			List<Governorat> governorats = governoratRepository.findAll();
			model.addAttribute("villes", villes);
			model.addAttribute("delegations", delegations);
			model.addAttribute("governorats", governorats);
			//ville = null;
			return "redirect:/admin/ville";
		}

		String libell = ville.getLibell();
		Delegation delegation = ville.getDelegation();
		if (libell != null && libell.length() > 0 && delegation != null) {
			ville = new Ville(libell);
			ville.setDelegation(delegation);
			// villes.add(ville);
			villeRepository.save(ville);
			return "redirect:/admin/ville";
		}
		String error_add = "Libelle is required!";
		// List<Ville> governorats = villeRepository.findAll();
		// model.addAttribute("governorats", governorats);
		// model.addAttribute("errorMessage", error);
		return "redirect:/admin/delegation";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {

		villeRepository.deleteById(id);
		// List<Ville> villes = villeRepository.findAll();
		// model.addAttribute("villes", villes);
		// model.addAttribute("errorDelete", error);
		// return "governorat";
		// return "redirect:/governorat/list";
		// return "delegation";
		return "redirect:/admin/ville";
	}

}
