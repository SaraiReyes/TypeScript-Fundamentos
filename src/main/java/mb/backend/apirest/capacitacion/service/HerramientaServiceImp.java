package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.HerramientasDao;
import mb.backend.apirest.capacitacion.entity.Herramienta;

@Service
public class HerramientaServiceImp implements HerramientaService{
	
	@Autowired
	private HerramientasDao ActivoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Herramienta> findAll() {
		return (List<Herramienta>)ActivoDao.findAll();
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<Herramienta> findStatus(String status) {
		return (List<Herramienta>)ActivoDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Herramienta findById(Integer id) {
		return ActivoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Herramienta save(Herramienta activo) {
		return ActivoDao.save(activo);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ActivoDao.deleteById(id);
	}


}
