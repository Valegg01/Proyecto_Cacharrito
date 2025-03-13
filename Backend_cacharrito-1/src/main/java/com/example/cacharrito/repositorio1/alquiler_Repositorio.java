package com.example.cacharrito.repositorio1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cacharrito.modelo1.alquiler;


public interface alquiler_Repositorio extends JpaRepository <alquiler, Long>{
	
	List<alquiler> findByIdUsuario(Long id_Usuario);

}
