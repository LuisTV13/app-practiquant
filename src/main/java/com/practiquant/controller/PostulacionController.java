package com.practiquant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiquant.entity.Postulacion;
import com.practiquant.service.PostulacionService;
import com.practiquant.util.Constantes;

@RestController
@RequestMapping("/practiquant/postulacion")
public class PostulacionController {
	
	@Autowired
	private PostulacionService postulacionservice;
	
	@GetMapping("/porPerfil")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> listaPostulacionporPerfil(@RequestParam(value ="codperfil" , required = false, defaultValue = "0")int codperfil){
		
		Map<String,Object>salida = new HashMap<String,Object>();
		try {
			List<Postulacion> lista = postulacionservice.listaPostulacionporPefil(codperfil);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existe elementos para la consulta");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tiene : "+lista.size()+" elementos");
			}
		}catch (Exception e) {
			salida.put("mensaje", "Error : "+ e.getMessage());
			
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String,Object>> Postular(@RequestBody Postulacion obj) {
		Map<String,Object> salida = new HashMap<>();
		
		try {
			Postulacion objsalida = postulacionservice.insertarActualizarPostulacion(obj);
		  if(objsalida == null) {
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

