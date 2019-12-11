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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CM_VILLE")

public class Ville {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@NotEmpty(message="libell non vide")
	@Length(max = 20 ,message="libell max 3")
	private String libell;

	@ManyToOne()
	
	private Delegation delegation;
	
	@OneToMany(mappedBy = "ville")
	private List<User> clients;
	
	@OneToMany(mappedBy = "ville")
	private List<Cafe> cafes;

	/*public Ville(String libell) {
		super();
		this.libell = libell;
	}
*/
	

	 
}
