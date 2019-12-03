package com.cafimanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CM_ACHAT")
public class Achat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public User getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(User fournisseur) {
		this.fournisseur = fournisseur;
	}


	public User getGerant() {
		return gerant;
	}


	public void setGerant(User gerant) {
		this.gerant = gerant;
	}


	public Jour getJour() {
		return jour;
	}


	public void setJour(Jour jour) {
		this.jour = jour;
	}


	public List<DetailAchat> getDetailAchat() {
		return detailAchat;
	}


	public void setDetailAchat(List<DetailAchat> detailAchat) {
		this.detailAchat = detailAchat;
	}

	

}
