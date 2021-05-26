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

import mb.backend.apirest.capacitacion.entity.KitHerramienta;
import mb.backend.apirest.capacitacion.service.EmpresaService;
import mb.backend.apirest.capacitacion.service.KitHerramientaService;
import mb.backend.apirest.capacitacion.service.ProveedorService;


@RestController
@RequestMapping("/api")
public class KitHerramientaRestController {
	
	@Autowired
	private KitHerramientaService kitsProductoService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ProveedorService proveedorService;
	

	@GetMapping("/kitsProducto")
	public List<KitHerramienta> index(){
		return this.kitsProductoService.findAll();
	}
	
	@GetMapping("/kitsProducto/catalogo/{status}")
	public List<KitHerramienta> EncontrarStatus(@PathVariable String status){
		return this.kitsProductoService.findStatus(status);
	}
	
	@GetMapping("/kitsProducto/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		KitHerramienta kitsProducto = null;
		Map<String, Object> response = new HashMap<>();
		try {
			kitsProducto = kitsProductoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(kitsProducto == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<KitHerramienta>(kitsProducto,HttpStatus.OK);
	}
	
	
	@PostMapping("/kitsProducto")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody KitHerramienta kitsProducto) {
		KitHerramienta kitProductoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			kitProductoNew = kitsProductoService.save(kitsProducto);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<KitHerramienta>(kitProductoNew,HttpStatus.OK);
	}
	
	@PutMapping("/kitsProducto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody KitHerramienta KitsProducto, @PathVariable Integer id) {
		KitHerramienta KitsProductoActual = null;
		KitHerramienta KitsProductoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			KitsProductoActual=this.kitsProductoService.findById(id);
			KitsProductoActual.setNombre(KitsProducto.getNombre());
			KitsProductoActual.setStatus(KitsProducto.getStatus());
			//KitsProductoActual.setProveedor(proveedorService.findById(KitsProducto.getId()));
			KitsProductoUpdate = this.kitsProductoService.save(KitsProductoActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", KitsProductoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
