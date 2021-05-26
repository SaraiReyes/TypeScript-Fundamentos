package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.LineaTelefonoDao;
import mb.backend.apirest.capacitacion.entity.LineaTelefono;

@Service
public class LineaTelefonoServiceImp implements LineaTelefonoService{
	
	@Autowired 
	private LineaTelefonoDao lineaTelefonoDao;

	@Override
	@Transactional(readOnly = true)
	public List<LineaTelefono> findAll() {
		return (List<LineaTelefono>)lineaTelefonoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<LineaTelefono> findStatus(String status) {
		return (List<LineaTelefono>)lineaTelefonoDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public LineaTelefono findById(Integer id) {
		return lineaTelefonoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public LineaTelefono save(LineaTelefono lineaTelefono) {
		return lineaTelefonoDao.save(lineaTelefono);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		lineaTelefonoDao.deleteById(id);
	}

}
