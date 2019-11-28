package com.cafimanager.model;

/**
 * Created by Yasin Mert on 25.02.2017.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_ROLE")
public class Role implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="role")
	private String role;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(String role) {
		super();
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}