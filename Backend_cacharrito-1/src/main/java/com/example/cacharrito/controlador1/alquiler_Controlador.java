package com.example.cacharrito.controlador1;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacharrito.modelo1.alquiler;
import com.example.cacharrito.modelo1.vehiculo;
import com.example.cacharrito.repositorio1.admin_Repositorio;
import com.example.cacharrito.repositorio1.alquiler_Repositorio;
import com.example.cacharrito.repositorio1.usuario_Repositorio;
import com.example.cacharrito.repositorio1.vehiculo_Repositorio;
import com.example.micacharrito.modelo.administrador;
import com.example.micacharrito.modelo.coches;
import com.example.micacharrito.modelo.persona;
import com.example.micacharrito.modelo.usuario;

@RestController
@RequestMapping("/alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class alquiler_Controlador {
	
	@Autowired
	private alquiler_Repositorio alquilerRepositorio;
	
	@Autowired
	private admin_Repositorio adminRepositorio;
	
	@Autowired
	private usuario_Repositorio usuarioRepositorio;
	
	@Autowired
	private vehiculo_Repositorio vehiculoRepositorio;
	
	
	// funcion que alamcena 
		@GetMapping("/registrar")
		public alquiler registroAlquiler(
				@RequestParam String placa,
				@RequestParam ("fechai") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha1,
				@RequestParam ("fechat") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha2,
				@RequestParam Long cedula,
				@RequestParam Long valor) {
			
			
			com.example.cacharrito.modelo1.administrador admin = this.adminRepositorio.findById(1L).get();
			
			com.example.cacharrito.modelo1.usuario usu = this.usuarioRepositorio.findByInumIden(cedula);
			
			vehiculo vehi = this.vehiculoRepositorio.findByPlaca(placa);	
			
			vehi.setEstado("ocupado");
			
			this.vehiculoRepositorio.save(vehi);
			
			alquiler nuevo = new alquiler(usu, vehi,admin, fecha1,fecha2,"pendiente", valor);
			
			this.alquilerRepositorio.save(nuevo);
			
			
			return nuevo;
		}
	

	@GetMapping("/listaDeAlquileres")
	public List<alquiler>listarAlquileres(){
		return alquilerRepositorio.findAll();
	}
	
	@PutMapping("/cancelarAlquiler")
	public String cancelarAlquiler(@RequestParam Long id_Alquiler) {
		Optional<alquiler> alquilerr = alquilerRepositorio.findById(id_Alquiler);
		if(alquilerr.isPresent()) {
			alquiler alquilerExistente = alquilerr.get();
			alquilerExistente.setEstado("Cancelado");
			
			
			alquilerRepositorio.save(alquilerExistente);
			return "Disponible";
		}
		return "Error: Alquiler no encontrado.";
	}

}
