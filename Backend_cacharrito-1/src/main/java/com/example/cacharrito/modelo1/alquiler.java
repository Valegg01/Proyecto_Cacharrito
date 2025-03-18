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

@Entity  
@Table(name ="alquiler") 

public class alquiler {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Alquiler")
	private Long idAlquiler;
	
	@ManyToOne()
	@JoinColumn(name="idUsuario",referencedColumnName="idUsuario")
	private usuario idUsuario;
	
	@ManyToOne()
	@JoinColumn(name="id_Vehiculo",referencedColumnName="id_Vehiculo")
	private vehiculo idVehiculo;
	
	@ManyToOne()
	@JoinColumn(name="id_Admin",referencedColumnName="id_Admin")
	private administrador idAdmin;
	
	@Temporal(TemporalType.DATE) // para determinar si usa horas o fechas o ambas
	//@DateTimeFormat(iso = ISO.DATE) // para guardar solo la fecha
	@DateTimeFormat(pattern = "dd/MM/yyy") // lo mismo pero se cambia el formato
	@Column(name="Fecha_Inicio", nullable = false )
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE) // para determinar si usa horas o fechas o ambas
	//@DateTimeFormat(iso = ISO.DATE) // para guardar solo la fecha
	@DateTimeFormat(pattern = "dd/MM/yyy") // lo mismo pero se cambia el formato
	@Column(name="fecha_Fin", nullable = false )
	private Date fechaFin;
	
	@Column(name="estado", nullable = false)
	private String estado;

	
	@Column(name="valor_Total", nullable = false)
	private String valorTotal;
	
	public alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public alquiler(usuario idUsuario, vehiculo id_vehiculo, administrador id_Admin, Date fecha_Inicio, Date fecha_Fin,
			String estado, String valor_Total) {
		super();
		this.idUsuario = idUsuario;
		this.idVehiculo = id_vehiculo;
		this.idAdmin = id_Admin;
		fechaInicio = fecha_Inicio;
		this.fechaFin = fecha_Fin;
		this.estado = estado;
		this.valorTotal = valor_Total;
	}

	public Long getId_Alquiler() {
		return idAlquiler;
	}

	public void setId_Alquiler(Long id_Alquiler) {
		this.idAlquiler = id_Alquiler;
	}

	public usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public vehiculo getId_vehiculo() {
		return idVehiculo;
	}

	public void setId_vehiculo(vehiculo id_vehiculo) {
		this.idVehiculo = id_vehiculo;
	}

	public administrador getId_Admin() {
		return idAdmin;
	}

	public void setId_Admin(administrador id_Admin) {
		this.idAdmin = id_Admin;
	}

	public Date getFecha_Inicio() {
		return fechaInicio;
	}

	public void setFecha_Inicio(Date fecha_Inicio) {
		fechaInicio = fecha_Inicio;
	}

	public Date getFecha_Fin() {
		return fechaFin;
	}

	public void setFecha_Fin(Date fecha_Fin) {
		this.fechaFin = fecha_Fin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValor_Total() {
		return valorTotal;
	}

	public void setValor_Total(String valor_Total) {
		this.valorTotal = valor_Total;
	}

	
	
	
}
