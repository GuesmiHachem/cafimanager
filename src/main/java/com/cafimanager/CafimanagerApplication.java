package com.cafimanager;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cafimanager.repository.DelegationRepository;
import com.cafimanager.repository.GovernoratRepository;

@SpringBootApplication
public class CafimanagerApplication implements CommandLineRunner{

	@Autowired
	public  GovernoratRepository governoratRepository;
	@Autowired
	public  DelegationRepository delegationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CafimanagerApplication.class, args);
		
	}
	


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Governorat gov1 =new  Governorat("Mannouba");
		Governorat gov2 =new  Governorat("Tunis");
		
		Delegation del1 = new Delegation("Borj el amri");
		Delegation del2 = new Delegation("Denden");
		Delegation del3 = new Delegation("beb khadhra");
		
		del1.setGovernorat(gov1);
		del2.setGovernorat(gov1);
		del3.setGovernorat(gov2);
		
		governoratRepository.save(gov1);
		governoratRepository.save(gov2);
		
		delegationRepository.save(del1);
		delegationRepository.save(del2);
		delegationRepository.save(del3);
		*/
	}
	
	

}
