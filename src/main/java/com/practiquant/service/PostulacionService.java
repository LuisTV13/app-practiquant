package com.practiquant.service;

import java.util.List;

import com.practiquant.entity.Postulacion;

public interface PostulacionService {
	
	public abstract List<Postulacion> listaPostulacionporPefil(int codperfil);
	
	public abstract Postulacion insertarActualizarPostulacion(Postulacion obj);

}
