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

import mb.backend.apirest.capacitacion.entity.LineaTelefono;
import mb.backend.apirest.capacitacion.service.LineaTelefonoService;
import mb.backend.apirest.capacitacion.service.ProveedorService;

@RestController
@RequestMapping("/api")
public class LineaTelefonoRestController {
	
	@Autowired
	private LineaTelefonoService lineaTelefonoService;
	
	@Autowired
	private ProveedorService proveedorService;
	

	@GetMapping("/lineaTelefono")
	public List<LineaTelefono> index(){
		return this.lineaTelefonoService.findAll();
	}
	
	@GetMapping("/lineaTelefono/catalogo/{status}")
	public List<LineaTelefono> EncontrarStatus(@PathVariable String status){
		return this.lineaTelefonoService.findStatus(status);
	}
	
	@GetMapping("/lineaTelefono/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		LineaTelefono lineaTelefono = null;
		Map<String, Object> response = new HashMap<>();
		try {
			lineaTelefono = lineaTelefonoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(lineaTelefono == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<LineaTelefono>(lineaTelefono,HttpStatus.OK);
	}
	
	@PostMapping("/lineaTelefono")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody LineaTelefono lineaTelefono) {
		LineaTelefono lineaTelefonoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
		    lineaTelefono.setProveedor(proveedorService.findById(lineaTelefono.getProveedor().getId()));
		    lineaTelefonoNew = lineaTelefonoService.save(lineaTelefono);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<LineaTelefono>(lineaTelefonoNew,HttpStatus.OK);
	}
	
	@PutMapping("/lineaTelefono/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody LineaTelefono lineaTelefono, @PathVariable Integer id) {
		LineaTelefono lineaTelefonoActual = null;
		LineaTelefono lineaTelefonoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {

			lineaTelefonoActual=this.lineaTelefonoService.findById(id);
			lineaTelefonoActual.setNumero(lineaTelefono.getNumero());
			lineaTelefonoActual.setObservacion(lineaTelefono.getObservacion());
			lineaTelefonoActual.setStatus(lineaTelefono.getStatus());
			lineaTelefonoActual.setProveedor(proveedorService.findById(lineaTelefono.getProveedor().getId()));
			lineaTelefonoUpdate = this.lineaTelefonoService.save(lineaTelefonoActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", lineaTelefonoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
