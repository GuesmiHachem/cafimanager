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
import com.cafimanager.serviceImp.UserServiceImpl;

@Service
public class Fixture {

	@Autowired
	public CafeRepository cafeRepository;
	@Autowired
	public UserServiceImpl userServiceImpl;
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

		Governorat g1 = new Governorat(0, "Tunis", null);
		Governorat g2 = new Governorat(0, "Mannouba", null);
		Governorat g3 = new Governorat(0, "Ariana", null);
		Governorat g4 = new Governorat(0, "Ben Arous", null);
		Governorat g5 = new Governorat(0, "Beja", null);
		Governorat g6 = new Governorat(0, "Jandouba", null);
		Governorat g7 = new Governorat(0, "Kef", null);
		Governorat g8 = new Governorat(0, "Sousse", null);

		/*
		 * Delegation
		 */

		Delegation d1 = new Delegation(0, "Borj El Amri", null, null);
		Delegation d2 = new Delegation(0, "Mornaguia", null, null);
		Delegation d3 = new Delegation(0, "Tebourba", null, null);

		/*
		 * Ville
		 */

		Ville v1 = new Ville(0, "Borj El Amri", null, null, null);
		Ville v2 = new Ville(0, "Borj Ennour", null, null, null);
		Ville v3 = new Ville(0, "Bir Ettouil", null, null, null);
		Ville v4 = new Ville(0, "Menzel Habib", null, null, null);

		/*
		 * ROLE
		 */

		Role r1 = new Role(0, "ADMIN", null);
		Role r2 = new Role(0, "CLIENT", null);
		Role r3 = new Role(0, "CAISSIER", null);
		Role r4 = new Role(0, "GERANT", null);
		Role r5 = new Role(0, "SERVEUR", null);

		/*
		 * USER
		 */

		User u1 = new User(0, "hachem@gmail.com", "azerty", "Guesmi Hachem", 1, null, null, null, null, null,null);
		User u2 = new User(0, "bilel@gmail.com", "azerty", "Bilel Azizi", 1, null, null, null, null, null,null);
		User u3 = new User(0, "karim@gmail.com", "azerty", "Karim Trojet", 1, null, null, null, null, null,null);
		User u4 = new User(0, "zouhair@gmail.com", "azerty", "Zouhair", 1, null, null, null, null, null,null);
		User u5 = new User(0, "mohsen@gmail.com", "azerty", "Trabelsi Mohsen", 1, null, null, null, null, null,null);
		User u6 = new User(0, "moncef@gmail.com", "azerty", "Moncef", 1, null, null, null, null, null,null);

		/*
		 * CAFE
		 */
		Cafe c1 = new Cafe(0, "El Madina", "71111222", null, null);
		/*
		 * ++++++++++++++++++++++++++++++++++++++++++++
		 */

		governoratRepository.save(g1);
		governoratRepository.save(g2);
		governoratRepository.save(g3);
		governoratRepository.save(g4);
		governoratRepository.save(g5);
		governoratRepository.save(g6);
		governoratRepository.save(g7);
		governoratRepository.save(g8);

		/*
		 * Delegation
		 */

		d1.setGovernorat(g2);
		d2.setGovernorat(g2);
		d3.setGovernorat(g2);

		delegationRepository.save(d1);
		delegationRepository.save(d2);
		delegationRepository.save(d3);

		/*
		 * Ville
		 */

		v1.setDelegation(d1);
		v2.setDelegation(d1);
		v3.setDelegation(d1);

		villeRepository.save(v1);
		villeRepository.save(v2);
		villeRepository.save(v3);

		/*
		 * ROLE
		 */

		r1 = roleRepository.save(r1);
		r2 = roleRepository.save(r2);
		r3 = roleRepository.save(r3);
		r4 = roleRepository.save(r4);
		r5 = roleRepository.save(r5);

		/*
		 * USER
		 */

		u1.setVille(v1);
		userServiceImpl.create(u1, r1);

		u2.setVille(v1);
		userServiceImpl.create(u2, r1);

		u3.setVille(v1);
		userServiceImpl.create(u3, r2);

		u4.setVille(v1);
		userServiceImpl.create(u4, r5);

		u5.setVille(v1);
		userServiceImpl.create(u5, r4);

		u6.setVille(v1);
		userServiceImpl.create(u6, r3);

		/*
		 * CAFE
		 */

		c1.setClient(u3);
		c1.setVille(v1);
		cafeRepository.save(c1);

	}

}
