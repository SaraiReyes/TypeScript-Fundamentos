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

import mb.backend.apirest.capacitacion.entity.Gama;
import mb.backend.apirest.capacitacion.service.GamaService;

@RestController
@RequestMapping("/api")
public class GamaRestController {
	
	@Autowired
	private GamaService gamaService;
	
	@GetMapping("/gama")
	public List<Gama> index(){
		return this.gamaService.findAll();
	}
	
	@GetMapping("/gama/catalogo/{status}")
	public List<Gama> EncontrarStatus(@PathVariable String status){
		return this.gamaService.findStatus(status);
	}
	
	@GetMapping("/gama/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Gama gama = null;
		Map<String, Object> response = new HashMap<>();
		try {
			gama = gamaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(gama == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Gama>(gama,HttpStatus.OK);
	}
	
	
	@PostMapping("/gama")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Gama gama) {
		Gama gamaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			gamaNew = gamaService.save(gama);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Gama>(gamaNew,HttpStatus.OK);
	}
	
	@PutMapping("/gama/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Gama gama, @PathVariable Integer id) {
		Gama gamaActual = null;
		Gama gamaUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			gamaActual=this.gamaService.findById(id);
			gamaActual.setNombreGama(gama.getNombreGama());
			gamaActual.setStatus(gama.getStatus());
			gamaUpdate = this.gamaService.save(gamaActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", gamaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
