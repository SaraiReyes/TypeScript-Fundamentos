package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.KitsProductoDao;
import mb.backend.apirest.capacitacion.entity.KitHerramienta;

@Service
public class KitHerramientaServiceImp implements KitHerramientaService{
	
	@Autowired
	private KitsProductoDao kitsProductoDao;

	@Override
	@Transactional(readOnly = true)
	public List<KitHerramienta> findAll() {
		return (List<KitHerramienta>)kitsProductoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<KitHerramienta> findStatus(String status) {
		return (List<KitHerramienta>)kitsProductoDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public KitHerramienta findById(Integer id) {
		return kitsProductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public KitHerramienta save(KitHerramienta kitsProducto) {
		return kitsProductoDao.save(kitsProducto);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		kitsProductoDao.deleteById(id);
	}

}
