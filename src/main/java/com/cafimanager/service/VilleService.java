package com.cafimanager.service;

import com.cafimanager.model.Ville;

public interface VilleService {
	
	public void create(Ville ville);
	public void delete(Long id);
	public void update(Ville ville);
	public void find(Long id);
	public void findAll();
	
}
