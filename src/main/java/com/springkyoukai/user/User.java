package com.springkyoukai.user;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class User {

	@Id
	@SequenceGenerator(
			name = "user_id",
			sequenceName = "user_id"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_id"
	)
	private Long id;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "auth_provider")
	private Provider provider;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
