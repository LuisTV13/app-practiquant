package com.practiquant.service;

import java.util.List;

import com.practiquant.entity.Usuario;

public interface UsuarioService {

	public abstract List<Usuario> listaUsuario();
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
}
