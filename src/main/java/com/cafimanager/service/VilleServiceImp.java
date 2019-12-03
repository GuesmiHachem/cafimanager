package com.cafimanager.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cafimanager.model.Delegation;
import com.cafimanager.model.Ville;
import com.cafimanager.repository.DelegationRepository;
import com.cafimanager.repository.GovernoratRepository;
import com.cafimanager.repository.VilleRepository;

//@Service("villeServiceImp")
@Component
public class VilleServiceImp implements VilleService{

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
			ville = new Ville(libell);
			ville.setDelegation(delegation);
			villeRepository.save(ville);
		}
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ville ville) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Scheduled(fixedDelay = 1000, initialDelay = 3000)
	   public void fixedDelaySch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Delay scheduler:: " + strDate);
	   }
	
	@Scheduled(cron = "0 * 16 * * ?")
	   public void cronJobSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Java cron job expression:: " + strDate);
	   }

}
