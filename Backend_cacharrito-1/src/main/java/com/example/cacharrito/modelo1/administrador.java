package com.example.cacharrito.modelo1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  
@Table(name ="administrador") 

public class administrador {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Admin")
	private Long idAdmin;
	
	@Column(name="usuario", nullable = false)
	private String usuario;

	
	@Column(name="password", nullable = false)
	private String password;


	public administrador() {
		super();
		// TODO Auto-generated constructor stub
	}


	public administrador(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}


	public Long getId_Admin() {
		return idAdmin;
	}


	public void setId_Admin(Long id_Admin) {
		this.idAdmin = id_Admin;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
