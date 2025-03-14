package com.example.cacharrito.controlador1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cacharrito.modelo1.administrador;
import com.example.cacharrito.repositorio1.admin_Repositorio;

public class admin_controlador {
	
	@Autowired
	private admin_Repositorio repadmin;
	
	
	@GetMapping("/loguinAdmin")
	public boolean loguinadmin (
			@RequestParam String usuario,
			@RequestParam String Password) {
		
		administrador encontrado = this.repadmin.findByUsuario(usuario).get();
		
		if(encontrado.getUsuario().equals(usuario) && encontrado.getPassword().equals(Password)) {
			
			return true;
			
		}else {
			
			return false;
			
		}
	}

}
