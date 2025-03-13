package com.example.cacharrito.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  /*esto establece la entidad en la base de datos*/
@Table(name ="vehiculo") // nombre de la tabla en la base de datos

public class vehiculo {
	
	
	
	@Id /* esto es para identificar el id como llave principal*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Vehiculo")
	/* Long es para definir que es un dato largo*/
	private Long id_Vehiculo;
	
	@Column(name="tipo", nullable = false)
	private String tipo;

	
	@Column(name="placa", nullable = false)
	private String placa;
	
	@Column(name="color",nullable = false)
	private String color;
	
	@Column(name="estado", nullable = false, unique = true)
	private String estado;

	public vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public vehiculo(Long id_Vehiculo, String tipo, String placa, String color, String estado) {
		super();
		this.id_Vehiculo = id_Vehiculo;
		this.tipo = tipo;
		this.placa = placa;
		this.color = color;
		this.estado = estado;
	}

	public Long getId_Vehiculo() {
		return id_Vehiculo;
	}

	public void setId_Vehiculo(Long id_Vehiculo) {
		this.id_Vehiculo = id_Vehiculo;
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
