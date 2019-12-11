package com.cafimanager.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafimanager.model.Ann;
import com.cafimanager.model.Categorie;
import com.cafimanager.model.Delegation;
import com.cafimanager.model.Ville;
import com.cafimanager.repository.DelegationRepository;
import com.cafimanager.repository.GovernoratRepository;
import com.cafimanager.repository.VilleRepository;

@Service("villeService")
@Transactional
public class VilleService implements IVilleService{

	@Autowired
	public VilleRepository villeRepository;
	@Autowired
	public DelegationRepository delegationRepository;
	@Autowired
	public GovernoratRepository governoratRepository;
	
	
	
	
	@Override
	public void create(Ville ville) {
		// TODO Auto-generated method stub
		String libell = ville.getLibell();
		Delegation delegation = ville.getDelegation();
		if (libell != null && libell.length() > 0 && delegation != null) {
			//ville = new Ville(libell);
			ville = new Ville(0, libell, delegation, null, null);
			ville.setDelegation(delegation);
			villeRepository.save(ville);
		}
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		villeRepository.deleteById(id);
	}

	@Override
	public void update(Ville ville) {
		// TODO Auto-generated method stub
		villeRepository.save(ville);
	}

	@Override
	public Ville findById(Long id) {
		// TODO Auto-generated method stub
		return villeRepository.findById(id).get();
	}

	@Override
	public List<Ville> findAll() {
		// TODO Auto-generated method stub
		return villeRepository.findAll();
	}

	@Override
	public Ville findByLibell(String libell) {
		// TODO Auto-generated method stub
		return villeRepository.findByLibell(libell);
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return villeRepository.count();
	}

	@Override
	public void deleteByLibell(String libell) {
		// TODO Auto-generated method stub
	    villeRepository.deleteByLibell(libell);
	}

	

	@Override
	public Page<Ville> findAll(int page, int size, Sort sort) {
		// TODO Auto-generated method stub
		return villeRepository.findAll(new PageRequest(page,size,sort));
	}

	@Override
	public List<Ville> findAllByLibell(String libell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Ville> findAllByLibell(int page, int size, Sort sort, String libell) {
		// TODO Auto-generated method stub
		
		return null;
	}
	

}
