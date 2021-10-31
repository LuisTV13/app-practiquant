package com.practiquant.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiquant.entity.Perfil;
import com.practiquant.service.PerfilService;
import com.practiquant.util.Constantes;

@RestController
@RequestMapping("/practiquant/perfil")
//@CrossOrigin(origins = "http://localhost:4200")
public class PerfilController {
	
	@Autowired 
	private PerfilService perfilservice;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String,Object>> insertarActualizarPerfil(@RequestBody Perfil obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Perfil objSalida = perfilservice.insertaActualizaPerfil(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
				
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
			
			
			
		}catch (Exception e) {
         e.printStackTrace();
         salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		
		}
		
		
		return ResponseEntity.ok(salida);
		
	}
	
	
	
	

}
