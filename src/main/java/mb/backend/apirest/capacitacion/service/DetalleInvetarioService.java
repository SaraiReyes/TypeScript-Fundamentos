package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.DetalleInvetario;

public interface DetalleInvetarioService {
	public List<DetalleInvetario> findAll();
	public DetalleInvetario findById(Integer id);
	public DetalleInvetario save(DetalleInvetario inventario);
	public void delete(Integer id);
}
