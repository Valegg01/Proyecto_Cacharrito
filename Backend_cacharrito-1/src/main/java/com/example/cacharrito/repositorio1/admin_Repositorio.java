package com.example.cacharrito.repositorio1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.cacharrito.modelo1.administrador;

public interface admin_Repositorio extends JpaRepository <administrador, Long> {
	
	Optional<administrador> findByUsuario(String usuario);

}
