package com.example.cacharrito.repositorio1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cacharrito.modelo1.alquiler;
import com.example.cacharrito.modelo1.usuario;


public interface alquiler_Repositorio extends JpaRepository <alquiler, Long>{

	List<alquiler>findByidUsuario(usuario idUsuario);

	List<alquiler> findByEstado(String string);

}
