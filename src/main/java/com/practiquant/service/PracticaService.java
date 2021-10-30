package com.practiquant.service;

import com.practiquant.entity.Practica;
import java.util.List;
import java.util.Optional;

public interface PracticaService {
	
	public abstract Practica insertaActualizaPractica(Practica obj);
	public abstract void eliminaPorId(int codigopractica);
	public abstract List<Practica> listaPracticaporPractica(String detallepractica);
	public Optional<Practica> buscarPorId(int codigopractica);
	
}
