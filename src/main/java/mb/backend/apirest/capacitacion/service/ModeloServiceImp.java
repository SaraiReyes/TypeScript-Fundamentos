package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.ModeloDao;
import mb.backend.apirest.capacitacion.entity.Modelo;

@Service
public class ModeloServiceImp implements ModeloService{
	
	@Autowired
	private ModeloDao modeloDao;

	@Override
	@Transactional(readOnly = true)
	public List<Modelo> findAll() {
		return (List<Modelo>)modeloDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Modelo> findStatus(String status) {
		return (List<Modelo>)modeloDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Modelo findById(Integer id) {
		return modeloDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Modelo save(Modelo modelo) {
		return modeloDao.save(modelo);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		modeloDao.deleteById(id);
	}

}
