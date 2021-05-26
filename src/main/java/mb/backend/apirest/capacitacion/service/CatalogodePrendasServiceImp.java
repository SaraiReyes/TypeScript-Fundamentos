package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.backend.apirest.capacitacion.dao.CatalogodePrendasDao;
import mb.backend.apirest.capacitacion.entity.CatalogodePrendas;

@Service
public class CatalogodePrendasServiceImp implements CatalogodePrendasService{

	@Autowired
	private CatalogodePrendasDao catalogodePrendasDao;

	@Override
	public List<CatalogodePrendas> findAll() {
		return catalogodePrendasDao.findAll();
	}

	@Override
	public CatalogodePrendas findById(Integer id) {
		return catalogodePrendasDao.findById(id).orElse(null);
	}

	@Override
	public CatalogodePrendas save(CatalogodePrendas prenda) {
		return catalogodePrendasDao.save(prenda);
	}

	@Override
	public void delete(Integer id) {
		catalogodePrendasDao.deleteById(id);
	}
}
