package com.practiquant.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.practiquant.entity.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {

}
