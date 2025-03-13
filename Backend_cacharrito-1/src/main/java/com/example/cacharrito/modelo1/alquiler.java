package com.example.cacharrito.modelo1;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity  /*esto establece la entidad en la base de datos*/
@Table(name ="alquiler") // nombre de la tabla en la base de datos

public class alquiler {
	
	@Id /* esto es para identificar el id como llave principal*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Alquiler")
	/* Long es para definir que es un dato largo*/
	private Long id_Alquiler;
	
	@ManyToOne()
	@JoinColumn(name="id_Usuario",referencedColumnName="id_Usuario")
	private usuario id_Usuario;
	
	@ManyToOne()
	@JoinColumn(name="id_Vehiculo",referencedColumnName="id_Vehiculo")
	private vehiculo id_vehiculo;
	
	@ManyToOne()
	@JoinColumn(name="id_Admin",referencedColumnName="id_Admin")
	private administrador id_Admin;
	
	@Temporal(TemporalType.DATE) // para determinar si usa horas o fechas o ambas
	//@DateTimeFormat(iso = ISO.DATE) // para guardar solo la fecha
	@DateTimeFormat(pattern = "dd/MM/yyy") // lo mismo pero se cambia el formato
	@Column(name="Fecha_Inicio", nullable = false )
	private Date Fecha_Inicio;
	
	@Temporal(TemporalType.DATE) // para determinar si usa horas o fechas o ambas
	//@DateTimeFormat(iso = ISO.DATE) // para guardar solo la fecha
	@DateTimeFormat(pattern = "dd/MM/yyy") // lo mismo pero se cambia el formato
	@Column(name="fecha_Fin", nullable = false )
	private Date fecha_Fin;
	
	@Column(name="estado", nullable = false)
	private String estado;

	
	@Column(name="valor_Total", nullable = false)
	private String valor_Total;
	
	public alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public alquiler(usuario id_Usuario, vehiculo id_vehiculo, administrador id_Admin, Date fecha_Inicio, Date fecha_Fin,
			String estado, String valor_Total) {
		super();
		this.id_Usuario = id_Usuario;
		this.id_vehiculo = id_vehiculo;
		this.id_Admin = id_Admin;
		Fecha_Inicio = fecha_Inicio;
		this.fecha_Fin = fecha_Fin;
		this.estado = estado;
		this.valor_Total = valor_Total;
	}

	public Long getId_Alquiler() {
		return id_Alquiler;
	}

	public void setId_Alquiler(Long id_Alquiler) {
		this.id_Alquiler = id_Alquiler;
	}

	public usuario getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(usuario id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public vehiculo getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(vehiculo id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public administrador getId_Admin() {
		return id_Admin;
	}

	public void setId_Admin(administrador id_Admin) {
		this.id_Admin = id_Admin;
	}

	public Date getFecha_Inicio() {
		return Fecha_Inicio;
	}

	public void setFecha_Inicio(Date fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}

	public Date getFecha_Fin() {
		return fecha_Fin;
	}

	public void setFecha_Fin(Date fecha_Fin) {
		this.fecha_Fin = fecha_Fin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValor_Total() {
		return valor_Total;
	}

	public void setValor_Total(String valor_Total) {
		this.valor_Total = valor_Total;
	}

	
	
	
}
