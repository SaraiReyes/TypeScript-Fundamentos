package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.TelefonoDao;
import mb.backend.apirest.capacitacion.entity.Telefono;

@Service
public class TelefonoServiceImp implements TelefonoService{
	
	@Autowired
	private TelefonoDao telefonoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Telefono> findAll() {
		return (List<Telefono>)telefonoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Telefono> findStatus(String status) {
		return (List<Telefono>)telefonoDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Telefono findById(Integer id) {
		return telefonoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Telefono save(Telefono telefono) {
		return telefonoDao.save(telefono);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		telefonoDao.deleteById(id);
	}

}
