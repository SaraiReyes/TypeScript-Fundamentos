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

import mb.backend.apirest.capacitacion.entity.DetalleInvetario;
import mb.backend.apirest.capacitacion.service.BitacoraEntradaService;
import mb.backend.apirest.capacitacion.service.DetalleInvetarioService;

@RestController
@RequestMapping("/api")
public class DetalleInvetarioRestController {

	@Autowired
	private DetalleInvetarioService detalleInvetarioService;
	
	@Autowired
	private BitacoraEntradaService bitacoraEntradaService;
	
	@GetMapping("/detalleInvetario")
	public List<DetalleInvetario> index(){
		return this.detalleInvetarioService.findAll();
	}
	
	@GetMapping("/detalleInvetario/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		DetalleInvetario detalleKit = null;
		Map<String, Object> response = new HashMap<>();
		try {
			detalleKit = detalleInvetarioService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(detalleKit == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<DetalleInvetario>(detalleKit,HttpStatus.OK);
	}
	
	
	@PostMapping("/detalleInvetario")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody DetalleInvetario detalle) {
		DetalleInvetario detalleInvetario = null;
		Map<String, Object> response = new HashMap<>();
		try {
			detalle.setIdBitacora(bitacoraEntradaService.findById(detalle.getIdBitacora().getId()));
			detalleInvetario = detalleInvetarioService.save(detalle);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<DetalleInvetario>(detalleInvetario,HttpStatus.OK);
	}
	
	@PutMapping("/detalleInvetario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody DetalleInvetario detalleKitProducto, @PathVariable Integer id) {
		DetalleInvetario detalleKitActual = null;
		DetalleInvetario detalleKitUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			detalleKitUpdate = this.detalleInvetarioService.save(detalleKitActual);
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", detalleKitUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
