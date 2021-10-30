package com.practiquant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiquant.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
