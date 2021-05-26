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

import mb.backend.apirest.capacitacion.entity.DetalleKitHerramienta;
import mb.backend.apirest.capacitacion.service.DetalleKitProductoService;
import mb.backend.apirest.capacitacion.service.KitHerramientaService;
import mb.backend.apirest.capacitacion.service.KitService;

@RestController
@RequestMapping("/api")
public class DetalleKitProductoRestController {
	
	@Autowired
	private DetalleKitProductoService detalleKitProductoService;
	
	@Autowired
	private KitHerramientaService kitsProductoService;
	
	@Autowired
	private KitService poductoService;
	
	@GetMapping("/detalleKit")
	public List<DetalleKitHerramienta> index(){
		return this.detalleKitProductoService.findAll();
		//return this.detalleKitProductoService.findAll();
	}
	
	@GetMapping("/detalleKit/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		DetalleKitHerramienta detalleKit = null;
		Map<String, Object> response = new HashMap<>();
		try {
			detalleKit = detalleKitProductoService.findById(id);
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
			return new ResponseEntity<DetalleKitHerramienta>(detalleKit,HttpStatus.OK);
	}
	
	
	@PostMapping("/detalleKit")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody DetalleKitHerramienta detalleKitProducto) {
		DetalleKitHerramienta detalleKitNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			detalleKitProducto.setProducto(poductoService.findById(detalleKitProducto.getProducto().getId()));
			detalleKitProducto.setKitsProducto(kitsProductoService.findById(detalleKitProducto.getKitsProducto().getId()));
			detalleKitNew = detalleKitProductoService.save(detalleKitProducto);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<DetalleKitHerramienta>(detalleKitNew,HttpStatus.OK);
	}
	
	@PutMapping("/detalleKit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody DetalleKitHerramienta detalleKitProducto, @PathVariable Integer id) {
		DetalleKitHerramienta detalleKitActual = null;
		DetalleKitHerramienta detalleKitUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			detalleKitActual=this.detalleKitProductoService.findById(id);
			detalleKitActual.setCantidad(detalleKitProducto.getCantidad());
			detalleKitActual.setStatus(detalleKitProducto.getStatus());
			detalleKitActual.setProducto(poductoService.findById(detalleKitProducto.getProducto().getId()));
			detalleKitActual.setKitsProducto(kitsProductoService.findById(detalleKitProducto.getKitsProducto().getId()));
			detalleKitUpdate = this.detalleKitProductoService.save(detalleKitActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", detalleKitUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
