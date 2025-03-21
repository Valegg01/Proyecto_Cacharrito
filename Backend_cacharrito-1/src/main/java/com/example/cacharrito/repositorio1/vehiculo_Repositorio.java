package com.example.cacharrito.repositorio1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cacharrito.modelo1.vehiculo;

public interface vehiculo_Repositorio  extends JpaRepository <vehiculo, Long> {
	
	List<vehiculo> findByestado(String estado);
	List<vehiculo> findBytipo(String tipo);
	List<vehiculo> findBytipoAndEstado(String tipo, String estado);

	List<vehiculo> findByEstadoAndTipo(String filtro, String tipo);

	
	

}
