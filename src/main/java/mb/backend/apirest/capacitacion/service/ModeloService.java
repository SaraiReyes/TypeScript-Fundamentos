package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Modelo;

public interface ModeloService {
	
	public List<Modelo> findAll();
	public List<Modelo> findStatus(String status);
	public Modelo findById(Integer id);
	public Modelo save(Modelo modelo);
	public void delete(Integer id);

}
