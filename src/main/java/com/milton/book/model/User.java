package com.milton.book.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	@Column(nullable = false)
	@NotEmpty
	private String name;
	@Column(nullable = false,unique = true)
	@NotEmpty
	@Email
	private String email;
	@Column(nullable = false)
	@NotEmpty
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",joinColumns = {@JoinColumn(referencedColumnName = "id",name = "user_id")},
	inverseJoinColumns = {@JoinColumn(referencedColumnName = "id",name = "role_id")})
	private List<Role>roles;
	
	
	
	
	public User() {
		
	}
	public User(Long id, @NotEmpty String name, @NotEmpty String email, @NotEmpty String password, List<Role> roles) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
