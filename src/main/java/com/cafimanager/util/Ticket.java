package com.cafimanager.util;

import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

	private String societeNom;
	private String societeSite;
	private String societeTel;
	private String numero;
	private String nom;
	private String adresse;
	private String tel;
	private String date;
	private String heure;
	private String caissier;
	private String serveur;
	private String description;
	private String remerciment;
}
