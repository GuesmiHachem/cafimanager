package com.cafimanager.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CM_ACHAT")
public class Achat{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne()
	private User fournisseur;
	
	@ManyToOne()
	private User gerant;
	
	@ManyToOne()
	private Jour jour;
	
	@OneToMany(mappedBy = "achat")
	private List<DetailAchat> detailAchat;

}
