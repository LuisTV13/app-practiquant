package com.practiquant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiquant.entity.Perfil;
import com.practiquant.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository perfilrepo;
	
	@Override
	public Perfil insertaActualizaPerfil(Perfil obj) {
	
		return perfilrepo.save(obj);
	}

}
