package com.cafimanager.controller;


import java.io.IOException;
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

import com.cafimanager.Fixture;
import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.model.Ville;
import com.cafimanager.repository.DelegationRepository;
import com.cafimanager.repository.GovernoratRepository;
import com.cafimanager.repository.VilleRepository;
import com.cafimanager.rest.SendMessage;
import com.cafimanager.service.VilleService;

@Controller
@RequestMapping("/admin/ville")
public class VilleController {

	@Autowired
	public SendMessage sendMessage;
	@Autowired
	public DelegationRepository delegationRepository;
	@Autowired
	public GovernoratRepository governoratRepository;
	@Autowired
	public VilleService villeService;
	
	public List<Ville> villes;
	public List<Delegation> delegations;
	public List<Governorat> governorats;
	public Ville ville;
	public Page<Ville> pageVilles;
	public int[] pages;
	public long id;
	@RequestMapping({ "", "/" })
	public String findall(Model model, @RequestParam(name="page", defaultValue="0") int page , @RequestParam(name="size", defaultValue="4") int size) {
		// ############################################## //
		villes = villeService.findAll();
		delegations = delegationRepository.findAll();
		governorats = governoratRepository.findAll();
		ville = new Ville();
		pageVilles = villeService.findAll(page, size, Sort.by("id"));
		pages = new int [pageVilles.getTotalPages()];		
		model.addAttribute("ville", ville);
		model.addAttribute("villes", villes);
		model.addAttribute("delegations", delegations);
		model.addAttribute("governorats", governorats);
		model.addAttribute("pageVilles", pageVilles.getContent());
		model.addAttribute("pages", pages);
		// ############################################## //
		return "admin/ville";
	}

	@RequestMapping("/{id}")
	public String find(@PathVariable("id") String idString, Model model, @RequestParam(name="page", defaultValue="0") int page , @RequestParam(name="size", defaultValue="4") int size) {		
		try {
			if (idString == null) {
				return "redirect:/admin/ville";
			}
			id = Long.parseLong(idString);
			ville = villeService.findById(id);
			if (ville != null) {
				// ############################################## //
				villes = villeService.findAll();
				delegations = delegationRepository.findAll();
				governorats = governoratRepository.findAll();
				pageVilles = villeService.findAll(page, size, Sort.by("id"));
				pages = new int [pageVilles.getTotalPages()];		
				model.addAttribute("ville", ville);
				model.addAttribute("villes", villes);
				model.addAttribute("delegations", delegations);
				model.addAttribute("governorats", governorats);
				model.addAttribute("pageVilles", pageVilles.getContent());
				model.addAttribute("pages", pages);
				// ############################################## //
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
		villeService.create(ville);
		return "redirect:/admin/ville";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String idString, Model model) {
		try {
			if (idString != null) {
				return "redirect:/admin/ville";
			}
			id = Long.parseLong(idString);
			ville = villeService.findById(id);
			if (ville != null) {
				villeService.deleteById(id);
				return "redirect:/admin/ville";
			} else {
				return "redirect:/admin/ville";
			}
		} catch (Exception e) {
			return "redirect:/admin/ville";
		}
	}
	
	@GetMapping("/azerty")
	public String azerty( Model model) {
		Fixture f = new Fixture();
		f.build();
		return "redirect:/admin/ville";
	}
	
	@GetMapping("/sms/{to}")
	public String sms( Model model , String to) {
		try {
			sendMessage.solde();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/ville";
	}
	
	

}
