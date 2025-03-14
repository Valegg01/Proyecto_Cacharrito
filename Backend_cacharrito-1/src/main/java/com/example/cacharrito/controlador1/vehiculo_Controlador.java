package com.example.cacharrito.controlador1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacharrito.modelo1.vehiculo;
import com.example.cacharrito.repositorio1.vehiculo_Repositorio;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin(origins = "http://localhost:4200/")
public class vehiculo_Controlador {
	
	@Autowired
	
	private vehiculo_Repositorio RepVehiculo;
	
	@PostMapping("/filtro")
	public List<vehiculo> filtroVheiculo(@RequestParam String filtro){
		
		return this.RepVehiculo.findByestado(filtro);
	}

}
