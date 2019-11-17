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

@Entity
@Table(name = "CM_DETAIL_ACHAT")
public class DetailAchat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne()
	private Achat achat;
	
	@ManyToOne()
	private ProduitAchat produitAchat;
	
	@Column
	private int qte;
	
	@Column
	private int montant;
	
	public DetailAchat() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Achat getAchat() {
		return achat;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}

	public ProduitAchat getProduitAchat() {
		return produitAchat;
	}

	public void setProduitAchat(ProduitAchat produitAchat) {
		this.produitAchat = produitAchat;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	
}
