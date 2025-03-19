package com.example.cacharrito.repositorio1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cacharrito.modelo1.usuario;

public interface usuario_Repositorio  extends JpaRepository <usuario, Long> {
	
Optional<usuario>findByCorreo(String correo);

Optional<usuario>findByNumIden(Long numIden);

Optional<usuario>findById(Long idUsuario);

usuario findByInumIden(Long cedula);


}
