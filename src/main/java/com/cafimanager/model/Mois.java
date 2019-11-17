package com.cafimanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "CM_MOIS")
public class Mois implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String mois;
	
	@ManyToOne()
	private Annee annee;

	@OneToMany(mappedBy = "mois")
	private List<Jour> jours;

	public Mois() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	
	public Mois(String mois) {
		super();
		this.mois = mois;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMois() {
		return mois;
	}


	public void setMois(String mois) {
		this.mois = mois;
	}


	public Annee getAnnee() {
		return annee;
	}


	public void setAnnee(Annee annee) {
		this.annee = annee;
	}



	public List<Jour> getJours() {
		return jours;
	}



	public void setJours(List<Jour> jours) {
		this.jours = jours;
	}


	
	
}
