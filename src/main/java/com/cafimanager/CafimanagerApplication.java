package com.cafimanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.cafimanager.repository.CafeRepository;


@SpringBootApplication
@EnableScheduling

public class CafimanagerApplication implements CommandLineRunner{

	@Autowired
	public Fixture fixture;
	public static void main(String[] args) {
		SpringApplication.run(CafimanagerApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		//fixture.build();
	}
	
	
	

}
