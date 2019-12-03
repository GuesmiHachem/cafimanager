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
@Table(name = "CM_PA")
public class ProduitAchat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String libell;
	
	@Column
	private int prix;
	
	@Column
	private String unite;

	@ManyToOne()
	private Cafe cafe;

	public ProduitAchat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProduitAchat(String libell, int prix, String unite) {
		super();
		this.libell = libell;
		this.prix = prix;
		this.unite = unite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibell() {
		return libell;
	}

	public void setLibell(String libell) {
		this.libell = libell;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	
	
}
