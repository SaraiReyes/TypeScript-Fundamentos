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

import mb.backend.apirest.capacitacion.entity.Empresa;
import mb.backend.apirest.capacitacion.service.EmpresaService;

@RestController
@RequestMapping("/api")
public class EmpresaRestController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/empresa")
	public List<Empresa> index(){
		return this.empresaService.findAll();
	}
	
	@GetMapping("/empresa/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Empresa empresa = null;
		Map<String, Object> response = new HashMap<>();
		try {
			empresa = empresaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(empresa == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
	}
	
	@PostMapping("/empresa")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Empresa empresa) {
		Empresa empresaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			empresaNew = empresaService.save(empresa);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Empresa>(empresaNew,HttpStatus.OK);
	}
	
	@PutMapping("/empresa/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Empresa empresa, @PathVariable Integer id) {
		Empresa empresaActual = null;
		Empresa empresaUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {

			empresaActual=this.empresaService.findById(id);
			empresaActual.setNombre(empresa.getNombre());
			empresaActual.setStatus(empresa.getStatus());
			empresaUpdate = this.empresaService.save(empresaActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", empresaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
