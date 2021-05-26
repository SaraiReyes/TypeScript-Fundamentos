package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.EmpresaDao;
import mb.backend.apirest.capacitacion.entity.Empresa;

@Service
public class EmpresaServiceImp implements EmpresaService{
	
	@Autowired
	private EmpresaDao empresaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return (List<Empresa>)empresaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findById(Integer id) {
		return empresaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		return empresaDao.save(empresa);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		empresaDao.deleteById(id);
	}

}
