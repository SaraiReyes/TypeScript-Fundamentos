package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> findAll();
	public List<Proveedor> findStatus(String status);
	public Proveedor findById(Integer id);
	public Proveedor save(Proveedor proveedor);
	public void delete(Integer id);

}
