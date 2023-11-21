package br.edu.atitus.poo.atitusound.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class UserEntity extends GenericEntity{
	private String email;
	private String username;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String name) {
		this.email = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
