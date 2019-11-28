package com.cafimanager.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "CM_GOVERNORAT")
public class Governorat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@Column
	private String libell;

	@OneToMany(mappedBy = "governorat")
	private List<Delegation> delegations;

	
	
	
	public Governorat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Governorat(String libell) {
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

	public List<Delegation> getDelegations() {
		return delegations;
	}

	public void setDelegations(List<Delegation> delegations) {
		this.delegations = delegations;
	}

	

}
