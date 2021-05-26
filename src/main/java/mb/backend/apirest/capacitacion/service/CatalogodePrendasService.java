package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.CatalogodePrendas;

public interface CatalogodePrendasService {
	public List<CatalogodePrendas> findAll();
	public CatalogodePrendas findById(Integer id);
	public CatalogodePrendas save(CatalogodePrendas preda);
	public void delete(Integer id);

}
