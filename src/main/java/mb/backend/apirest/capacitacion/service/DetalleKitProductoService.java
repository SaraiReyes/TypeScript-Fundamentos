package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.DetalleKitHerramienta;


public interface DetalleKitProductoService {
	
	public List<DetalleKitHerramienta> findAll();
	public DetalleKitHerramienta findById(Integer id);
	public DetalleKitHerramienta save(DetalleKitHerramienta detalleKitProducto);
	public void delete(Integer id);

}
