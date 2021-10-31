package com.practiquant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practiquant.entity.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
	
	@Query(" select p from Postulacion p where " 
			+ "(:p_per is 0 or p.codperfil = :p_per)")
	public abstract List<Postulacion> listaPostulacionPorPefil(@Param("p_per") int codperfil);

}
