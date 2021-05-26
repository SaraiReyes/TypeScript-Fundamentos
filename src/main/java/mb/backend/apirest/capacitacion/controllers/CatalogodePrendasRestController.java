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

import mb.backend.apirest.capacitacion.entity.CatalogodePrendas;
import mb.backend.apirest.capacitacion.service.CatalogodePrendasService;

@RestController
@RequestMapping("/api")
public class CatalogodePrendasRestController {
	
	@Autowired
	private CatalogodePrendasService catalogodePrendasService;
	
	@GetMapping("/catalogo/prendas")
	public List<CatalogodePrendas> index(){
		return this.catalogodePrendasService.findAll();
	}
	
	@GetMapping("/catalogo/prendas/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		CatalogodePrendas catalogo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			catalogo = catalogodePrendasService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(catalogo == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<CatalogodePrendas>(catalogo,HttpStatus.OK);
	}
	
	
	@PostMapping("/catalogo/prendas")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody CatalogodePrendas catalogo) {
		CatalogodePrendas catalogoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			catalogoNew = catalogodePrendasService.save(catalogo);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<CatalogodePrendas>(catalogoNew,HttpStatus.OK);
	}
	
	@PutMapping("/catalogo/prendas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody CatalogodePrendas catalogo, @PathVariable Integer id) {
		CatalogodePrendas catalogoActual = null;
		CatalogodePrendas catalogoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			catalogoActual = this.catalogodePrendasService.findById(id);
			catalogoActual.setDescripcion(catalogo.getDescripcion());
			catalogoActual.setNombre(catalogo.getNombre());
			catalogoActual.setStatus(catalogo.getStatus());
			catalogoUpdate = catalogodePrendasService.save(catalogo);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", catalogoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
