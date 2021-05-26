package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.PrendaDao;
import mb.backend.apirest.capacitacion.entity.Prenda;

@Service
public class PrendaServiceImp implements PrendaService{
	
	@Autowired 
	private PrendaDao prendaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Prenda> findAll() {
		return (List<Prenda>)prendaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Prenda findById(Integer id) {
		return prendaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Prenda save(Prenda prenda) {
		return prendaDao.save(prenda);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		prendaDao.deleteById(id);
	}

}
