package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Telefono;

public interface TelefonoService {
	
	public List<Telefono> findAll();
	public List<Telefono> findStatus(String status);
	public Telefono findById(Integer id);
	public Telefono save(Telefono modelo);
	public void delete(Integer id);

}
