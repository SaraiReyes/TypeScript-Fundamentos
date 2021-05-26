package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Kit;

public interface KitService {
	
	public List<Kit> findAll();
	public Kit findById(Integer id);
	public Kit save(Kit Producto);
	public void delete(Integer id);

}
