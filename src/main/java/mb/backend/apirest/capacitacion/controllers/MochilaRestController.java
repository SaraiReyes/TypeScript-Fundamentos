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

import mb.backend.apirest.capacitacion.entity.Mochila;
import mb.backend.apirest.capacitacion.service.HerramientaService;
import mb.backend.apirest.capacitacion.service.EmpresaService;
import mb.backend.apirest.capacitacion.service.MarcaService;
import mb.backend.apirest.capacitacion.service.MochilaService;
import mb.backend.apirest.capacitacion.service.ProveedorService;

@RestController
@RequestMapping("/api")
public class MochilaRestController {
	
	@Autowired
	private MochilaService mochilaService;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired 
	private HerramientaService  activoService;

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/mochila")
	public List<Mochila> index(){
		return this.mochilaService.findAll();
	}
	
	@GetMapping("/mochila/catalogo/{status}")
	public List<Mochila> EncontrarStatus(@PathVariable String status){
		return this.mochilaService.findStatus(status);
	}
	
	@GetMapping("/mochila/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Mochila mochila = null;
		Map<String, Object> response = new HashMap<>();
		try {
			mochila = mochilaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(mochila == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<Mochila>(mochila,HttpStatus.OK);
	}
	
	@PostMapping("/mochila")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody Mochila mochila) {
		Mochila mochilaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {

			mochila.setActivo(activoService.findById(mochila.getActivo().getId()));
			mochila.setMarca(marcaService.findById(mochila.getMarca().getId()));
			mochila.setProveedor(proveedorService.findById(mochila.getProveedor().getId()));
			mochila.setEmpresa(empresaService.findById(mochila.getEmpresa().getId()));
			mochilaNew = mochilaService.save(mochila);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<Mochila>(mochilaNew,HttpStatus.OK);
	}
	
	@PutMapping("/mochila/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody Mochila mochila, @PathVariable Integer id) {
		Mochila mochilaActual = null;
		Mochila mochilaUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {

			mochilaActual=this.mochilaService.findById(id);
			mochilaActual.setBordado(mochila.getBordado());
			mochilaActual.setColor(mochila.getColor());
			mochilaActual.setStatus(mochila.getStatus());
			mochilaActual.setTamano(mochila.getTamano());
			mochilaActual.setActivo(activoService.findById(mochila.getActivo().getId()));
			mochilaActual.setProveedor(proveedorService.findById(mochila.getProveedor().getId()));
			mochilaActual.setMarca(marcaService.findById(mochila.getMarca().getId()));
			mochilaActual.setEmpresa(empresaService.findById(mochila.getEmpresa().getId()));
			mochilaUpdate = this.mochilaService.save(mochilaActual);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", mochilaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
