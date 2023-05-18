package com.springkyoukai.user;

import jakarta.persistence.*;

@Entity
public class Role {
	@Id
	@SequenceGenerator(
			name = "id",
			sequenceName = "id"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "id"
	)
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
