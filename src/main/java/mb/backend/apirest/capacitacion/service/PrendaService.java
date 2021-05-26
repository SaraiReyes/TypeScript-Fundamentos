package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Prenda;

public interface PrendaService {
	
	public List<Prenda> findAll();
	public Prenda findById(Integer id);
	public Prenda save(Prenda prenda);
	public void delete(Integer id);

}
