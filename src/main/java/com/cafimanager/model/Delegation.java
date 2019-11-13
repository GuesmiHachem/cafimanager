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
@Table(name = "CM_DELEGATION")
public class Delegation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String libell;

	@ManyToOne()
	private Governorat governorat;
	@OneToMany(mappedBy = "delegation")
	private List<Ville> villes;

	public Delegation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delegation(String libell) {
		super();
		this.libell = libell;
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

	public Governorat getGovernorat() {
		return governorat;
	}

	public void setGovernorat(Governorat governorat) {
		this.governorat = governorat;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

}
