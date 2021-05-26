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

import mb.backend.apirest.capacitacion.entity.Telefono;
import mb.backend.apirest.capacitacion.service.HerramientaService;
import mb.backend.apirest.capacitacion.service.EstadoTelefonoService;
import mb.backend.apirest.capacitacion.service.LineaTelefonoService;
import mb.backend.apirest.capacitacion.service.ModeloService;
import mb.backend.apirest.capacitacion.service.TelefonoService;

@RestController
@RequestMapping("/api")
public class TelefonoRestController {
	
	@Autowired
	private TelefonoService telefonoService;
	
	@Autowired
	private EstadoTelefonoService estadoTelefonoService;
	
	@Autowired
	private LineaTelefonoService lineaTelefonoService;
	
	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private HerramientaService activoService;
	
	@GetMapping("/telefono")
	public List<Telefono> index(){
		return this.telefonoService.findAll();
	}
	

	@GetMapping("/telefono/catalogo/{status}")
	public List<Telefono> EncontrarStatus(@PathVariable String status){
		return this.telefonoService.findStatus(status);
	}
	
	@GetMapping("/telefono/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Telefono telefono = null;
		Map<String, Object> response = new HashMap<>();
		try {
			telefono = telefonoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(telefono == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Telefono>(telefono,HttpStatus.OK);
	}
	
	@PostMapping("/telefono")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Telefono telefono) {
		Telefono telefonoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			telefono.setEstadoTelefono(estadoTelefonoService.findById(telefono.getEstadoTelefono().getId()));
			telefono.setLineaTelefono(lineaTelefonoService.findById(telefono.getLineaTelefono().getId()));
			telefono.setModelo(modeloService.findById(telefono.getModelo().getId()));
			telefono.setActivo(activoService.findById(telefono.getActivo().getId()));
			telefonoNew = telefonoService.save(telefono);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Telefono>(telefonoNew,HttpStatus.OK);
	}
	
	@PutMapping("/telefono/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Telefono telefono, @PathVariable Integer id) {
		Telefono telefonoActual = null;
		Telefono telefonoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {

			telefonoActual=this.telefonoService.findById(id);
			telefonoActual.setIMEI(telefono.getIMEI());
			telefonoActual.setPrecio(telefono.getPrecio());
			telefonoActual.setStatus(telefono.getStatus());
			telefonoActual.setEstadoTelefono(estadoTelefonoService.findById(telefono.getEstadoTelefono().getId()));
			telefonoActual.setLineaTelefono(lineaTelefonoService.findById(telefono.getLineaTelefono().getId()));
			telefonoActual.setModelo(modeloService.findById(telefono.getModelo().getId()));
			telefonoActual.setActivo(activoService.findById(telefono.getActivo().getId()));
			telefonoUpdate = this.telefonoService.save(telefonoActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", telefonoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
