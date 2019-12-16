package com.cafimanager.model;


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
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CM_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;	
	@Column(name = "email")
	@Email(message = "*Please enter a valid email adress!")
	@NotEmpty(message = "*Please provide an email! This field can not be empty!")
	private String email;	
	@Column(name = "password")
	@Length(min = 3, message = "*Your password can not be less than 3 characters!")
	@NotEmpty(message = "*Please provide your password! This field can not be empty!")
	@org.springframework.data.annotation.Transient
	private String password;	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name! This field can not be empty!")
	private String name;	
	@Column(name = "active")
	private int active;		
	@ManyToOne
	private Role role;	
	@ManyToOne
	private Ville ville;	
	@OneToMany(mappedBy = "client")
	private List<Cafe> cafes;	
	@OneToMany(mappedBy = "gerant")
	private List<Achat> achatsGerant;	
	@OneToMany(mappedBy = "fournisseur")
	private List<Achat> achatsFournisseur;
	@ManyToOne
	private Cafe cafe;	
	
}