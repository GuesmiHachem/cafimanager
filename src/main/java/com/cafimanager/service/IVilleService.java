package com.cafimanager.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.model.Ville;

public interface IVilleService {
	
	public void create(Ville ville);
	public void deleteById(Long id);
	public void deleteByLibell(String libell);
	public void update(Ville ville);
	public Ville findById(Long id);
	public Ville findByLibell(String libell);
	public List<Ville> findAll();
	public List<Ville> findAllByLibell(String libell);
	public Page<Ville> findAll(int page,int size,Sort sort);
	public Page<Ville> findAllByLibell(int page,int size,Sort sort,String libell);
	public long size();
	
	
}
