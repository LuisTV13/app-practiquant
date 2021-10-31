package com.practiquant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiquant.entity.Usuario;
import com.practiquant.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl2 implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}

}
