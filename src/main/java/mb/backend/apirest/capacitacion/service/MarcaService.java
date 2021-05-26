package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Marca;

public interface MarcaService {
	
	public List<Marca> findAll();
	public List<Marca> findStatus(String status);
	public Marca findById(Integer id);
	public Marca save(Marca Marca);
	public void delete(Integer id);

}
