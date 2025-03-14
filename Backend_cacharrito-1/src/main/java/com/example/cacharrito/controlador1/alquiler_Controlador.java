package com.example.cacharrito.controlador1;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacharrito.modelo1.alquiler;
import com.example.cacharrito.repositorio1.alquiler_Repositorio;

@RestController
@RequestMapping("/alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class alquiler_Controlador {
	
	@Autowired
	private alquiler_Repositorio alquilerRepositorio;
	
	@PostMapping("/registrarAlquiler")
	public void registrarAlquiler(@RequestBody alquiler alquilerr) {
		alquilerRepositorio.save(alquilerr);
	}
	
	@PostMapping("/solicitarAlquiler")
	public List<alquiler>consultarAlquileresPorUsuario(@RequestBody Map<String, Long> request){
		Long id_Usuario = request.get("id_Usuario");
		return alquilerRepositorio.findByIdUsuario(id_Usuario);
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
