package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.MarcaDao;
import mb.backend.apirest.capacitacion.entity.Marca;

@Service
public class MarcaServiceImp implements MarcaService{
	
	@Autowired
	private MarcaDao marcaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findAll() {
		return (List<Marca>)marcaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findStatus(String status) {
		return (List<Marca>)marcaDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Marca findById(Integer id) {
		return marcaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Marca save(Marca marca) {
		return marcaDao.save(marca);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		marcaDao.deleteById(id);
	}

}
