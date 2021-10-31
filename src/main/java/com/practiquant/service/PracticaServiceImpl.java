package com.practiquant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiquant.entity.Practica;
import com.practiquant.repository.PracticaRepository;

@Service
public class PracticaServiceImpl implements PracticaService {

	@Autowired
	private PracticaRepository repository;
	
	@Override
	public Practica insertaActualizaPractica(Practica obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void eliminaPorId(int codigopractica) {
		repository.deleteById(codigopractica);
	}

	
	@Override
	public List<Practica> listaPracticaporPractica(String detallepractica) {
		// TODO Auto-generated method stub
		return repository.listaPracticaporPractica(detallepractica);
	}

	@Override
	public Optional<Practica> buscarPorId(int codigopractica) {
		// TODO Auto-generated method stub
		return repository.findById(codigopractica);
	}

}
