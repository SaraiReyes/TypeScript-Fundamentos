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

import mb.backend.apirest.capacitacion.entity.BitacoraEntrada;
import mb.backend.apirest.capacitacion.service.BitacoraEntradaService;

@RestController
@RequestMapping("/api")
public class DetalleBitacoraRestController {
	
	@Autowired
	private BitacoraEntradaService bitacoraEntradaService;
	
	@GetMapping("/bitacoraEntrada")
	public List<BitacoraEntrada> index(){
		return this.bitacoraEntradaService.findAll();
	}
	
	@GetMapping("/bitacoraEntrada/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		BitacoraEntrada bitacora = null;
		Map<String, Object> response = new HashMap<>();
		try {
			bitacora = bitacoraEntradaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al obtener el dato");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(bitacora == null) {
			response.put("mensaje", "¡el ID:"+id+" no existe!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		else 
			response.put("mensaje", "encontrado con exito");
			return new ResponseEntity<BitacoraEntrada>(bitacora,HttpStatus.OK);
	}
	
	
	@PostMapping("/bitacoraEntrada")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> create(@RequestBody BitacoraEntrada bitacora) {
		BitacoraEntrada bitacora2 = null;
		Map<String, Object> response = new HashMap<>();
		try {
			bitacora2 = bitacoraEntradaService.save(bitacora);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al registrar");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		    response.put("mensaje", "registrado con exito");
			return new ResponseEntity<BitacoraEntrada>(bitacora2,HttpStatus.OK);
	}
	
	@PutMapping("/bitacoraEntrada/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<?> update(@RequestBody BitacoraEntrada bitacora, @PathVariable Integer id) {
		BitacoraEntrada bitacoraActual = null;
		BitacoraEntrada bitacoraUpdate = null;
		Map<String, Object> response = new HashMap<>();
		try {
			bitacoraActual.setCantidad(bitacora.getCantidad());
			bitacoraActual.setFactura(bitacora.getFactura());
			bitacoraActual.setFechaCompra(bitacora.getFechaCompra());
			bitacoraActual.setFechaIngreso(bitacora.getFechaIngreso());
			bitacoraActual.setIdResponsable(bitacora.getIdResponsable());
			bitacoraActual.setProveedor(bitacora.getProveedor());
			bitacoraActual.setTotal(bitacora.getTotal());
			bitacoraActual.setTotalSinIva(bitacora.getTotalSinIva());
			bitacoraUpdate = this.bitacoraEntradaService.save(bitacora);
			
		} catch (Exception e) {
			response.put("mensaje", "¡Error de actualización ID: "+id+"!");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "actualizado con exito");
		response.put("mensaje", bitacoraUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
