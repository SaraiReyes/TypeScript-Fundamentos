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

import mb.backend.apirest.capacitacion.entity.Modelo;
import mb.backend.apirest.capacitacion.service.GamaService;
import mb.backend.apirest.capacitacion.service.MarcaService;
import mb.backend.apirest.capacitacion.service.ModeloService;

@RestController
@RequestMapping("/api")
public class ModeloRestController {
	
	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private GamaService gamaService;
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/modelo")
	public List<Modelo> index(){
		return this.modeloService.findAll();
	}
	

	@GetMapping("/modelo/catalogo/{status}")
	public List<Modelo> EncontrarStatus(@PathVariable String status){
		return this.modeloService.findStatus(status);
	}
	
	@GetMapping("/modelo/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Modelo modelo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			modelo = modeloService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(modelo == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Modelo>(modelo,HttpStatus.OK);
	}
	
	@PostMapping("/modelo")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Modelo modelo) {
		Modelo modeloNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			modelo.setGama(gamaService.findById(modelo.getGama().getId()));
			modelo.setMarca(marcaService.findById(modelo.getMarca().getId()));
			modeloNew = modeloService.save(modelo);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Modelo>(modeloNew,HttpStatus.OK);
	}
	

	@PutMapping("/modelo/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Modelo modelo, @PathVariable Integer id) {
		Modelo modeloActual = null;
		Modelo modeloUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {

			modeloActual=this.modeloService.findById(id);
			modeloActual.setModelo(modelo.getModelo());
			modeloActual.setStatus(modelo.getStatus());
			modeloActual.setGama(gamaService.findById(modelo.getGama().getId()));
			modeloActual.setMarca(marcaService.findById(modelo.getMarca().getId()));
			modeloUpdate = this.modeloService.save(modeloActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", modeloUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}


}
