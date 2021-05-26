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

import mb.backend.apirest.capacitacion.entity.EstadoTelefono;
import mb.backend.apirest.capacitacion.service.EstadoTelefonoService;

@RestController
@RequestMapping("/api")
public class EstadoTelefonoRestController {
	
	@Autowired
	private EstadoTelefonoService estadoTelefonoService;
	
	@GetMapping("/estadoTelefono")
	public List<EstadoTelefono> index(){
		return this.estadoTelefonoService.findAll();
	}
	
	@GetMapping("/estadoTelefono/catalogo/{status}")
	public List<EstadoTelefono> EncontrarStatus(@PathVariable String status){
		return this.estadoTelefonoService.findStatus(status);
	}
	

	@GetMapping("/estadoTelefono/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		EstadoTelefono estadoTelefono = null;
		Map<String, Object> response = new HashMap<>();
		try {
			estadoTelefono = estadoTelefonoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(estadoTelefono == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<EstadoTelefono>(estadoTelefono,HttpStatus.OK);
	}
	
	
	@PostMapping("/estadoTelefono")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody EstadoTelefono estadoTelefono) {
		EstadoTelefono estadoTelefonoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			estadoTelefonoNew = estadoTelefonoService.save(estadoTelefono);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<EstadoTelefono>(estadoTelefonoNew,HttpStatus.OK);
	}
	
	@PutMapping("/estadoTelefono/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody EstadoTelefono estadoTelefono, @PathVariable Integer id) {
		EstadoTelefono estadoTelefonoActual = null;
		EstadoTelefono estadoTelefonoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			estadoTelefonoActual=this.estadoTelefonoService.findById(id);
			estadoTelefonoActual.setStatus(estadoTelefono.getStatus());
			estadoTelefonoActual.setEstadoTelefono(estadoTelefono.getEstadoTelefono());
			estadoTelefonoUpdate = this.estadoTelefonoService.save(estadoTelefonoActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", estadoTelefonoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
