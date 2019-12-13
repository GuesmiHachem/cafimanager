package com.cafimanager.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "CM_USER")
public class User implements UserDetails, HttpSessionBindingListener {

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

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(
			@Email(message = "*Please enter a valid email adress!") @NotEmpty(message = "*Please provide an email! This field can not be empty!") String email,
			@Length(min = 3, message = "*Your password can not be less than 3 characters!") @NotEmpty(message = "*Please provide your password! This field can not be empty!") String password,
			@NotEmpty(message = "*Please provide your name! This field can not be empty!") String name, int active) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.active = active;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Cafe> getCafes() {
		return cafes;
	}

	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}


	public List<Achat> getAchatsGerant() {
		return achatsGerant;
	}


	public void setAchatsGerant(List<Achat> achatsGerant) {
		this.achatsGerant = achatsGerant;
	}


	public List<Achat> getAchatsFournisseur() {
		return achatsFournisseur;
	}


	public void setAchatsFournisseur(List<Achat> achatsFournisseur) {
		this.achatsFournisseur = achatsFournisseur;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
    public void valueBound(HttpSessionBindingEvent event) {
        User user = (User)event.getValue();
        System.out.println("New user bound in session with name: " + user.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        User user = (User)event.getValue();
        System.out.println("User with name: " + user.getName() + " removed from session");
    }
	
	
	

}