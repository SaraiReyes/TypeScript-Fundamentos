package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.KitDao;
import mb.backend.apirest.capacitacion.entity.Kit;

@Service
public class KitServiceImp implements KitService{
	
	@Autowired
	private KitDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Kit> findAll() {
		return (List<Kit>)productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Kit findById(Integer id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Kit save(Kit producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		productoDao.deleteById(id);
	}

}
