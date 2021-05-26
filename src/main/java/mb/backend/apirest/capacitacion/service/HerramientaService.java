package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Herramienta;

public interface HerramientaService {
	
	public List<Herramienta> findAll();
	public List<Herramienta> findStatus(String status);
	public Herramienta findById(Integer id);
	public Herramienta save(Herramienta activo);
	public void delete(Integer id);

}
