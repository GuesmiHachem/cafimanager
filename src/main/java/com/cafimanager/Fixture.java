package com.cafimanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafimanager.model.Cafe;
import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.model.Role;
import com.cafimanager.model.User;
import com.cafimanager.model.Ville;
import com.cafimanager.repository.CafeRepository;
import com.cafimanager.repository.DelegationRepository;
import com.cafimanager.repository.GovernoratRepository;
import com.cafimanager.repository.RoleRepository;
import com.cafimanager.repository.UserRepository;
import com.cafimanager.repository.VilleRepository;

@Service
public class Fixture {
	
	@Autowired
	public CafeRepository cafeRepository;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public RoleRepository roleRepository;
	@Autowired
	public GovernoratRepository governoratRepository;
	@Autowired
	public DelegationRepository delegationRepository;
	@Autowired
	public VilleRepository villeRepository;

	public void build() {
		/*
		 * GOVERNORAT
		 */
		/*
		 * Governorat g1=new Governorat("Tunis"); Governorat g2=new
		 * Governorat("Mannouba"); Governorat g3=new Governorat("Ariana"); Governorat
		 * g4=new Governorat("Ben Arous"); Governorat g5=new Governorat("Beja");
		 * Governorat g6=new Governorat("Jandouba"); Governorat g7=new
		 * Governorat("Kef"); Governorat g8=new Governorat("Sousse");
		 */
		
		/*
		 * Delegation
		 */
		/*
		 * Delegation d1=new Delegation("Borj El Amri"); Delegation d2=new
		 * Delegation("Mornaguia"); Delegation d3=new Delegation("Tebourba");
		 */
		
		/*
		 * Ville
		 */
		/*
		 * Ville v1=new Ville("Borj El Amri"); Ville v2=new Ville("Borj Ennour"); Ville
		 * v3=new Ville("Bir Ettouil"); Ville v4=new Ville("Menzel Habib");
		 */
		
		
		
		/*
		 * ROLE
		 */
		/*
		 * Role r1=new Role("ADMIN"); Role r2=new Role("CLIENT"); Role r3=new
		 * Role("CAISSIER"); Role r4=new Role("GERANT"); Role r5=new Role("SERVEUR");
		 */
		/*
		 * USER
		 */
		/*
		 * User u1=new User("hachem@gmail.com", "azerty", "Guesmi Hachem", 1); User
		 * u2=new User("bilel@gmail.com", "azerty", "Bilel Azizi", 1); User u3=new
		 * User("karim@gmail.com", "azerty", "Karim Trojet", 1); User u4=new
		 * User("zouhair@gmail.com", "azerty", "Zouhair", 1); User u5=new
		 * User("mohsen@gmail.com", "azerty", "Trabelsi Mohsen", 1); User u6=new
		 * User("moncef@gmail.com", "azerty", "Moncef", 1);
		 */
		/*
		 * CAFE
		 */
		/* Cafe c1=new Cafe("El Madina", "71111222"); */
		/*
		 * ++++++++++++++++++++++++++++++++++++++++++++
		 */
		
		
		/*
		 * governoratRepository.save(g1); governoratRepository.save(g2);
		 * governoratRepository.save(g3); governoratRepository.save(g4);
		 * governoratRepository.save(g5); governoratRepository.save(g6);
		 * governoratRepository.save(g7); governoratRepository.save(g8);
		 */
		
		/*
		 * Delegation
		 */
		
		/*
		 * d1.setGovernorat(g2); d2.setGovernorat(g2); d3.setGovernorat(g2);
		 * 
		 * delegationRepository.save(d1); delegationRepository.save(d2);
		 * delegationRepository.save(d3);
		 */
		
		
		/*
		 * Ville
		 */
		/*
		 * v1.setDelegation(d1); v2.setDelegation(d1); v3.setDelegation(d1);
		 * 
		 * villeRepository.save(v1); villeRepository.save(v2); villeRepository.save(v3);
		 */
				
		
		/*
		 * ROLE
		 */
		/*
		 * r1=roleRepository.save(r1); r2=roleRepository.save(r2);
		 * r3=roleRepository.save(r3); r4=roleRepository.save(r4);
		 * r5=roleRepository.save(r5);
		 */
		/*
		 * USER
		 */
		
		
		/*
		 * u1.setRole(r1); u1.setVille(v1); u1=userRepository.save(u1);
		 * 
		 * 
		 * u2.setRole(r1); u2.setVille(v1); u2=userRepository.save(u2);
		 * 
		 * 
		 * u3.setRole(r2); u3.setVille(v1); u3=userRepository.save(u3);
		 * 
		 * 
		 * u4.setRole(r5); u4.setVille(v1); u4=userRepository.save(u4);
		 * 
		 * u5=userRepository.save(u4); u5.setRole(r4);
		 * 
		 * 
		 * u6.setRole(r3); u6.setVille(v1); u6=userRepository.save(u6);
		 */
		/*
		 * CAFE
		 */
		/*
		 * c1.setClient(u3); c1.setVille(v1); cafeRepository.save(c1);
		 */
	}
	
	

}
