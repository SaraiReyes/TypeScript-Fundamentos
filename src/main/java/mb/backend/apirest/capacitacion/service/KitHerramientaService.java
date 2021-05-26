package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.KitHerramienta;

public interface KitHerramientaService {

	public List<KitHerramienta> findAll();
	public List<KitHerramienta> findStatus(String status);
	public KitHerramienta findById(Integer id);
	public KitHerramienta save(KitHerramienta kitsProducto);
	public void delete(Integer id);
}
