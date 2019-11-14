package com.cafimanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	 @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	    public String addPersonSave(Model model,  Governorat governorat) {
	 
	        
		 
		 
		 String libell = governorat.getLibell();
	 
	        if (libell != null && libell.length() > 0 ) {
	        	Governorat newGovernorat = new Governorat(libell);
	            //persons.add(newPerson);
	        	governoratRepository.save(newGovernorat);
	            return "redirect:/governorat/list";
	        }
	        String error = "Libelle is required!";
	        List<Governorat> governorats =governoratRepository.findAll();
			model.addAttribute("governorats",governorats);
	        model.addAttribute("errorMessage", error);
	        return "governorat";
	    }
	
	 
	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable Long id,Model model){
	       
	    	//Long blogId = Long.parseLong(id);
	        governoratRepository.deleteById(id);
        	
            
	    	
	    	String error = "Suppression impossible";
	        List<Governorat> governorats =governoratRepository.findAll();
			model.addAttribute("governorats",governorats);
	        model.addAttribute("errorDelete", error);
	        //return "governorat";
	       // return "redirect:/governorat/list";
	       // return "delegation";
	        return "redirect:/governorat/list";
	    }
	
	
}
