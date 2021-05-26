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

import mb.backend.apirest.capacitacion.entity.Marca;
import mb.backend.apirest.capacitacion.service.MarcaService;

@RestController
@RequestMapping("/api")
public class MarcaRestController {
	
	@Autowired
	private MarcaService marcaService;
	
	
	@GetMapping("/marca")
	public List<Marca> index(){
		return this.marcaService.findAll();
	}
	
	@GetMapping("/marca/catalogo/{status}")
	public List<Marca> EncontrarStatus(@PathVariable String status){
		return this.marcaService.findStatus(status);
	}
	
	@GetMapping("/marca/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Marca marca = null;
		Map<String, Object> response = new HashMap<>();
		try {
			marca = marcaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(marca == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Marca>(marca,HttpStatus.OK);
	}
	
	
	@PostMapping("/marca")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Marca marca) {
		Marca marcaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			marcaNew = marcaService.save(marca);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Marca>(marcaNew,HttpStatus.OK);
	}
	
	@PutMapping("/marca/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Marca marca, @PathVariable Integer id) {
		Marca marcaActual = null;
		Marca marcaUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			marcaActual=this.marcaService.findById(id);
			marcaActual.setNombreMarca(marca.getNombreMarca());
			marcaActual.setStatus(marca.getStatus());
			marcaUpdate = this.marcaService.save(marcaActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", marcaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

}
