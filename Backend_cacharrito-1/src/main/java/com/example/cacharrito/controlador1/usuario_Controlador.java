package com.example.cacharrito.controlador1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacharrito.modelo1.usuario;
import com.example.cacharrito.repositorio1.usuario_Repositorio;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200/")

public class usuario_Controlador {
	
	@Autowired
	private usuario_Repositorio usuarioRepositorio;
	
	@GetMapping("/buscarPorCorreo")
	public usuario buscarPorCorreo(@RequestParam String correo) {
		return usuarioRepositorio.findByCorreo(correo).orElse(null);
	}
	
	@GetMapping("/buscarPorIdentificacion")
	public usuario buscarPorIdentificacion(@RequestParam Long numIden) {
		return usuarioRepositorio.findByNumIden(numIden).orElse(null);
	}
	
	@GetMapping("/buscarPorId")
	public usuario buscarPorId(@RequestParam Long idUsuario) {
		return usuarioRepositorio.findById(idUsuario).orElse(null);
	}
	
	@GetMapping("/listaDeUsuarios")
	public List<usuario> listarUsuarios(){
		return usuarioRepositorio.findAll();
	}
	
	@PostMapping("/registroUsuario")
	public String registrarUsuario(@RequestBody usuario usuarioo) {
		if(usuarioRepositorio.findByCorreo(usuarioo.getCorreo()).isPresent()||
				usuarioRepositorio.findByNumIden(usuarioo.getNum_Iden()).isPresent()) {
			return "Error: Correo o identificacion ya registrados.";
			}
		usuarioRepositorio.save(usuarioo);
		return "Usuario regristrado exitosamente.";
	}
}
