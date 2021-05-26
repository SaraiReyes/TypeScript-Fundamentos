package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.ProveedorDao;
import mb.backend.apirest.capacitacion.entity.Proveedor;

@Service
public class ProveedorServiceImp implements ProveedorService{
	
	@Autowired 
	private ProveedorDao proveedorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findAll() {
		return (List<Proveedor>)proveedorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findStatus(String status) {
		return (List<Proveedor>)proveedorDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findById(Integer id) {
		return proveedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		return proveedorDao.save(proveedor);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		proveedorDao.deleteById(id);
	}


}
