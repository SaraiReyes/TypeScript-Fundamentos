package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.InventarioProducto;

public interface InventarioProductoService {
	
	public List<InventarioProducto> findAll();
	public InventarioProducto findById(Integer id);
	public InventarioProducto save(InventarioProducto inventarioProducto);
	public void delete(Integer id);

}
