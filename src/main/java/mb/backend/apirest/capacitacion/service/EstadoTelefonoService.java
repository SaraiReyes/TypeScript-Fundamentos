package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.EstadoTelefono;

public interface EstadoTelefonoService {
	
	public List<EstadoTelefono> findAll();
	public List<EstadoTelefono> findStatus(String status);
	public EstadoTelefono findById(Integer id);
	public EstadoTelefono save(EstadoTelefono estadoTelefono);
	public void delete(Integer id);

}
