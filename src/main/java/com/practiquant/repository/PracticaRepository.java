package com.practiquant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practiquant.entity.Practica;

public interface PracticaRepository extends JpaRepository<Practica, Integer>{

	
	@Query("select d from Practica d where "
			+ "( :p_nom is '' or d.detallepractica like :p_nom )")
	public  abstract List<Practica> listaPracticaporPractica(@Param("p_nom")String detallepractica);
}
