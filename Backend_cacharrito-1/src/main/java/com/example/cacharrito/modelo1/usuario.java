package com.example.cacharrito.modelo1;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
		@Column(name = "idUsuario")
		private Long idUsuario;
		
		@Column(name="nombre", nullable = false)
		private String nombre;
		
		@Column(name="num_Iden", nullable = false)
		private Long numIden;
		
		@Temporal(TemporalType.DATE) // para determinar si usa horas o fechas o ambas
		@DateTimeFormat(iso = ISO.DATE) // para guardar solo la fecha
		@Column(name="fecha_Exp", nullable = false )
		private Date fecha_Exp;

		
		@Column(name="categoria_Licencia", nullable = false)
		private String categoria_Licencia;
		
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
			this.fecha_Exp = fecha_Exp;
			this.categoria_Licencia = categoria_Licencia;
			this.correo = correo;
			this.telefono = telefono;
			this.password = password;
		}

		public Long getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Long getNumIden() {
			return numIden;
		}

		public void setNumIden(Long num_Iden) {
			this.numIden = num_Iden;
		}

		public Date getFecha_Exp() {
			return fecha_Exp;
		}

		public void setFecha_Exp(Date fechaExp) {
			this.fecha_Exp = fechaExp;
		}

		public String getCategoria_Licencia() {
			return categoria_Licencia;
		}

		public void setCategoria_Licencia(String categoria_Licencia) {
			this.categoria_Licencia = categoria_Licencia;
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
