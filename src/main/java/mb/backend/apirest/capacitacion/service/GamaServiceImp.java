package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.GamaDao;
import mb.backend.apirest.capacitacion.entity.Gama;

@Service
public class GamaServiceImp implements GamaService{
	
	@Autowired
	private GamaDao gamaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Gama> findAll() {
		return (List<Gama>)gamaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Gama> findStatus(String status) {
		return (List<Gama>)gamaDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Gama findById(Integer id) {
		return gamaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Gama save(Gama gama) {
		return gamaDao.save(gama);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		gamaDao.deleteById(id);
	}

}
