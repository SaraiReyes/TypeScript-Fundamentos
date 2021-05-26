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

import mb.backend.apirest.capacitacion.entity.TipoMovimiento;
import mb.backend.apirest.capacitacion.service.TipoMovimientoService;

@RestController
@RequestMapping("/api")
public class TipoMovimientoRestController {
	
	@Autowired
	private TipoMovimientoService tipoMovimientoService;
	
	@GetMapping("/tipoMovimiento")
	public List<TipoMovimiento> index(){
		return this.tipoMovimientoService.findAll();
	}
	
	@GetMapping("/tipoMovimiento/catalogo/{status}")
	public List<TipoMovimiento> EncontrarStatus(@PathVariable String status){
		return this.tipoMovimientoService.findStatus(status);
	}
	
	@GetMapping("/tipoMovimiento/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		TipoMovimiento motivoBaja = null;
		Map<String, Object> response = new HashMap<>();
		try {
			motivoBaja = tipoMovimientoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(motivoBaja == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<TipoMovimiento>(motivoBaja,HttpStatus.OK);
	}
	
	
	@PostMapping("/tipoMovimiento")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody TipoMovimiento movimiento) {
		TipoMovimiento movimientoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			movimientoNew = tipoMovimientoService.save(movimiento);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<TipoMovimiento>(movimientoNew,HttpStatus.OK);
	}
	
	@PutMapping("/tipoMovimiento/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody TipoMovimiento movimiento, @PathVariable Integer id) {
		TipoMovimiento movimientoActual = null;
		TipoMovimiento movimientoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			movimientoActual=this.tipoMovimientoService.findById(id);
			movimientoActual.setNombreMovimiento(movimiento.getNombreMovimiento());
			movimientoActual.setStatus(movimiento.getStatus());
			movimientoUpdate = this.tipoMovimientoService.save(movimientoActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", movimientoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
