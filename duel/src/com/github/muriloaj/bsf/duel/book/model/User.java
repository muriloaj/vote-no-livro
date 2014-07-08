package com.github.muriloaj.bsf.duel.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	@Id
	@NotEmpty(message = "* Obrigatório") 
	@Email (message = "email@dominio.com")
	private String email;
	@NotEmpty(message = "* Obrigatório") 
	@Size(min=3,message=" Tamanho mínimo {min}")
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
