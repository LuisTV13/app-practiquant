package com.practiquant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiquant.entity.Practica;
import com.practiquant.service.PracticaService;

@RestController
@RequestMapping("/practica")
@CrossOrigin(origins ="http://localhost:4200")
public class PracticaController {
	@Autowired
	private  PracticaService practicaService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String,Object>> insertUpdateProveedor(@RequestBody Practica obj){
		
		Map<String,Object> output = new HashMap<>();
		try {
			if(obj.getEstado() ==0) {
				obj.setEstado(1);
			}
			Practica objOut = practicaService.insertaActualizaPractica(obj);
			
			if(objOut ==null) {
				output.put("mensaje", "ERROR al Registrar el Proveedor");
			
			}else {
				output.put("mensaje", "EXITO al Registrar el Proveedor");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			output.put("mensaje","ERROR al Registrar el Proveedor");
			
		}
		return ResponseEntity.ok(output);	
	}
	
	
	@GetMapping("/porPractica")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPorPractica(
			@RequestParam(value = "nom", required = false, defaultValue = "") String nom) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Practica> lista = practicaService.listaPracticaporPractica("%"+nom+"%");
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "No existe elementos para la consulta");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tiene " + lista.size() + " elementos");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/{paramId}")
	@ResponseBody
	public ResponseEntity<Practica> eliminaPractica(@PathVariable("paramId") int codpractica){
		Optional<Practica> optAlumno = practicaService.buscarPorId(codpractica);
		if (optAlumno.isPresent()) {
			practicaService.eliminaPorId(codpractica);
			Optional<Practica> optSalida = practicaService.buscarPorId(codpractica);
			if (optSalida.isPresent()) {
				return ResponseEntity.badRequest().build();
			}else {
				return ResponseEntity.ok(optAlumno.get());
			}
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	
	
	

}
