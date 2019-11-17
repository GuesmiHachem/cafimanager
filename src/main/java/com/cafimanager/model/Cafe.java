package com.cafimanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "CM_CAFE")
public class Cafe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nomCafe;

	@Column
	private String tel;

	@ManyToOne()
	private Ville ville;

	@ManyToOne()
	private Client client;

	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cafe(String nomCafe, String tel) {
		super();
		this.nomCafe = nomCafe;
		this.tel = tel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomCafe() {
		return nomCafe;
	}

	public void setNomCafe(String nomCafe) {
		this.nomCafe = nomCafe;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}



}
