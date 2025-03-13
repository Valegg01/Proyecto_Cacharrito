package com.example.cacharrito.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  /*esto establece la entidad en la base de datos*/
@Table(name ="administrador") // nombre de la tabla en la base de datos

public class administrador {
	
	@Id /* esto es para identificar el id como llave principal*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Admin")
	/* Long es para definir que es un dato largo*/
	private Long id_Admin;
	
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
		return id_Admin;
	}


	public void setId_Admin(Long id_Admin) {
		this.id_Admin = id_Admin;
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
