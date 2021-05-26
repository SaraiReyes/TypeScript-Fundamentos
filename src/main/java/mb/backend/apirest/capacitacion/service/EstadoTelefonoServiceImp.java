package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.EstadoTelefonoDao;
import mb.backend.apirest.capacitacion.entity.EstadoTelefono;

@Service
public class EstadoTelefonoServiceImp implements EstadoTelefonoService{
	
	@Autowired
	private EstadoTelefonoDao estadoTelefonoDao;

	@Override
	@Transactional(readOnly = true)
	public List<EstadoTelefono> findAll() {
		return (List<EstadoTelefono>)estadoTelefonoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstadoTelefono> findStatus(String status) {
		return (List<EstadoTelefono>)estadoTelefonoDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public EstadoTelefono findById(Integer id) {
		return estadoTelefonoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public EstadoTelefono save(EstadoTelefono estadoTelefono) {
		return estadoTelefonoDao.save(estadoTelefono);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		estadoTelefonoDao.deleteById(id);
	}

}
