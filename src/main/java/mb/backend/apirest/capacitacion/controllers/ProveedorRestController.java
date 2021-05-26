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

import mb.backend.apirest.capacitacion.entity.Proveedor;
import mb.backend.apirest.capacitacion.service.ProveedorService;

@RestController
@RequestMapping("/api")
public class ProveedorRestController {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/proveedor")
	public List<Proveedor> index(){
		List<Proveedor> lista=this.proveedorService.findAll();
		System.out.println(lista.size());
		return lista;
	}
	
	@GetMapping("/proveedor/catalogo/{status}")
	public List<Proveedor> EncontrarStatus(@PathVariable String status){
		return this.proveedorService.findStatus(status);
	}
	
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Proveedor proveedor = null;
		Map<String, Object> response = new HashMap<>();
		try {
			proveedor = proveedorService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(proveedor == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Proveedor>(proveedor,HttpStatus.OK);
	}
	
	@PostMapping("/proveedor")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Proveedor proveedor) {
		Proveedor proveedorNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			proveedorNew = proveedorService.save(proveedor);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Proveedor>(proveedorNew,HttpStatus.OK);
	}
	
	@PutMapping("/proveedor/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Proveedor proveedor, @PathVariable Integer id) {
		Proveedor proveedorActual = null;
		Proveedor proveedorUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {

			proveedorActual=this.proveedorService.findById(id);
			proveedorActual.setCalle(proveedor.getCalle());
			proveedorActual.setCorreo(proveedor.getCorreo());
			proveedorActual.setEstado(proveedor.getEstado());
			proveedorActual.setLocalidad(proveedor.getLocalidad());
			proveedorActual.setMunicipio(proveedor.getMunicipio());
			proveedorActual.setNombre(proveedor.getNombre());
			proveedorActual.setRfc(proveedor.getRfc());
			proveedorActual.setStatus(proveedor.getStatus());
			proveedorActual.setTelefono(proveedor.getTelefono());
			proveedorUpdate = this.proveedorService.save(proveedorActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", proveedorUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
