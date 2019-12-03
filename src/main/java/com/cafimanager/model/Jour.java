package com.cafimanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CM_JOUR")
public class Jour implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String jour;

	@ManyToOne()
	private Mois mois;

	public Jour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jour(String jour) {
		super();
		this.jour = jour;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Mois getMois() {
		return mois;
	}

	public void setMois(Mois mois) {
		this.mois = mois;
	}

}
