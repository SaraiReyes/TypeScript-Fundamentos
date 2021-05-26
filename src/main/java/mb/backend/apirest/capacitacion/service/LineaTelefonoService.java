package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.LineaTelefono;

public interface LineaTelefonoService {
	
	public List<LineaTelefono> findAll();
	public List<LineaTelefono> findStatus(String status);
	public LineaTelefono findById(Integer id);
	public LineaTelefono save(LineaTelefono lineaTelefono);
	public void delete(Integer id);

}
