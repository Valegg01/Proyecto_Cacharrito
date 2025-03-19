package com.example.cacharrito.controlador1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacharrito.modelo1.administrador;
import com.example.cacharrito.repositorio1.admin_Repositorio;


@RestController
@RequestMapping("/admin/")
@CrossOrigin(origins="http://localhost:4200/")
public class admin_controlador {
	
	@Autowired
	private admin_Repositorio repadmin;
	
	
	@GetMapping("/loguinAdmin")
	public ResponseEntity<Boolean> loguinadmin(@RequestParam String usuario, @RequestParam String Password) {
	    try {
	        Optional<administrador> optionalEncontrado = this.repadmin.findByUsuario(usuario);
	        if (optionalEncontrado.isPresent()) {
	            administrador encontrado = optionalEncontrado.get();
	            if (encontrado.getPassword().equals(Password)) {
	                return ResponseEntity.ok(true);
	            } else {
	                return ResponseEntity.ok(false);
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false); // Usuario no encontrado
	        }
	    } catch (Exception e) {
	        System.err.println("Error al intentar iniciar sesión: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false); // Error interno
	    }
	}
	

}
