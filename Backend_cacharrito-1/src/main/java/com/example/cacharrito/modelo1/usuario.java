package com.example.cacharrito.modelo1;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity  
@Table(name ="usuario") 

public class usuario {
		
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_Usuario")
		private Long idUsuario;
		
		@Column(name="nombre", nullable = false)
		private String nombre;
		
		@Column(name="num_Iden", nullable = false)
		private Long numIden;
		
		@Temporal(TemporalType.DATE) // para determinar si usa horas o fechas o ambas
		//@DateTimeFormat(iso = ISO.DATE) // para guardar solo la fecha
		@DateTimeFormat(pattern = "MM/dd/yyy") // lo mismo pero se cambia el formato
		@Column(name="fecha_Exp", nullable = false )
		private Date fechaExp;

		
		@Column(name="categoria_Licencia", nullable = false)
		private String categoriaLicencia;
		
		@Column(name="correo",nullable = false)
		private String correo;
		
		@Column(name="telefono", nullable = false, unique = true)
		private String telefono;
		
		@Column(name="password", nullable = false, unique = true)
		private String password;

		public usuario() {
			super();
			// TODO Auto-generated constructor stub
		}

		public usuario(String nombre, Long num_Iden, Date fecha_Exp, String categoria_Licencia, String correo,
				String telefono, String password) {
			super();
			this.nombre = nombre;
			this.numIden = num_Iden;
			this.fechaExp = fecha_Exp;
			this.categoriaLicencia = categoria_Licencia;
			this.correo = correo;
			this.telefono = telefono;
			this.password = password;
		}

		public Long getId_Usuario() {
			return idUsuario;
		}

		public void setId_Usuario(Long id_Usuario) {
			this.idUsuario = id_Usuario;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Long getNum_Iden() {
			return numIden;
		}

		public void setNum_Iden(Long num_Iden) {
			this.numIden = num_Iden;
		}

		public Date getFecha_Exp() {
			return fechaExp;
		}

		public void setFecha_Exp(Date fecha_Exp) {
			this.fechaExp = fecha_Exp;
		}

		public String getCategoria_Licencia() {
			return categoriaLicencia;
		}

		public void setCategoria_Licencia(String categoria_Licencia) {
			this.categoriaLicencia = categoria_Licencia;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		
   
}
