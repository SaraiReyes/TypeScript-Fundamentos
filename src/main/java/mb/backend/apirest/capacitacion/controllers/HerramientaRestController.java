package mb.backend.apirest.capacitacion.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import mb.backend.apirest.capacitacion.entity.Herramienta;
import mb.backend.apirest.capacitacion.service.HerramientaService;

@RestController
@RequestMapping("/api")
public class HerramientaRestController {
	
	@Autowired
	private HerramientaService activoService;
	
	@GetMapping("/herramienta")
	public List<Herramienta> index(){
		return this.activoService.findAll();
	}
	
	@GetMapping("/herramienta/catalogo/{status}")
	public List<Herramienta> EncontrarStatus(@PathVariable String status){
		return this.activoService.findStatus(status);
	}
	
	@GetMapping("/herramienta/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Herramienta activo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			activo = activoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(activo == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Herramienta>(activo,HttpStatus.OK);
	}
	
	
	@PostMapping("/herramienta")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Herramienta herramienta) {
		Herramienta activoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			activoNew = activoService.save(herramienta);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Herramienta>(activoNew,HttpStatus.OK);
	}
	
	@PutMapping("/herramienta/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Herramienta herramienta, @PathVariable Integer id) {
		Herramienta activoActual = null;
		Herramienta activoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			activoActual=this.activoService.findById(id);
			activoActual.setHerramienta(herramienta.getHerramienta());
			activoActual.setStatus(herramienta.getStatus());
			activoUpdate = this.activoService.save(activoActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", activoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

}
