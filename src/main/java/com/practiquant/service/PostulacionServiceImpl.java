package com.practiquant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiquant.entity.Postulacion;
import com.practiquant.repository.PostulacionRepository;

@Service
public class PostulacionServiceImpl implements PostulacionService {
   
	@Autowired 
	private PostulacionRepository postulacionrepo;
	
	@Override
	public List<Postulacion> listaPostulacionporPefil(int codperfil) {
		
		return postulacionrepo.listaPostulacionPorPefil(codperfil);
	}

	@Override
	public Postulacion insertarActualizarPostulacion(Postulacion obj) {
		return postulacionrepo.save(obj);
	}

}
