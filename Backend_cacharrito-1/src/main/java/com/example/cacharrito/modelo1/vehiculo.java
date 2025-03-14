package com.example.cacharrito.modelo1;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name ="vehiculo") 
public class vehiculo {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Vehiculo")
	private Long idVehiculo;
	
	@Column(name="tipo", nullable = false)
	private String tipo;

	
	@Column(name="placa", nullable = false)
	private String placa;
	
	@Column(name="color",nullable = false)
	private String color;
	
	@Column(name="estado", nullable = false)
	private String estado;

	public vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public vehiculo(Long id_Vehiculo, String tipo, String placa, String color, String estado) {
		super();
		this.idVehiculo = id_Vehiculo;
		this.tipo = tipo;
		this.placa = placa;
		this.color = color;
		this.estado = estado;
	}

	public Long getId_Vehiculo() {
		return idVehiculo;
	}

	public void setId_Vehiculo(Long id_Vehiculo) {
		this.idVehiculo = id_Vehiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

		
	

}
