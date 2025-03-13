package com.example.cacharrito.modelo;

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

@Entity  /*esto establece la entidad en la base de datos*/
@Table(name ="usuario") // nombre de la tabla en la base de datos

public class usuario {
		
		
		/* estos son los atributos del obejtos (entidad de la bd)*/
		@Id /* esto es para identificar el id como llave principal*/
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_Usuario")
		/* Long es para definir que es un dato largo*/
		private Long id_Usuario;
		
		@Column(name="nombre", nullable = false)
		private String nombre;
		
		@Column(name="num_Iden", nullable = false)
		private Long num_Iden;
		
		@Temporal(TemporalType.DATE) // para determinar si usa horas o fechas o ambas
		//@DateTimeFormat(iso = ISO.DATE) // para guardar solo la fecha
		@DateTimeFormat(pattern = "MM/dd/yyy") // lo mismo pero se cambia el formato
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
			this.num_Iden = num_Iden;
			this.fecha_Exp = fecha_Exp;
			this.categoria_Licencia = categoria_Licencia;
			this.correo = correo;
			this.telefono = telefono;
			this.password = password;
		}

		public Long getId_Usuario() {
			return id_Usuario;
		}

		public void setId_Usuario(Long id_Usuario) {
			this.id_Usuario = id_Usuario;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Long getNum_Iden() {
			return num_Iden;
		}

		public void setNum_Iden(Long num_Iden) {
			this.num_Iden = num_Iden;
		}

		public Date getFecha_Exp() {
			return fecha_Exp;
		}

		public void setFecha_Exp(Date fecha_Exp) {
			this.fecha_Exp = fecha_Exp;
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
