package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.DetalleKitProductoDao;
import mb.backend.apirest.capacitacion.entity.DetalleKitHerramienta;

@Service
public class DetalleKitProductoServiceImp implements DetalleKitProductoService{
	
	@Autowired
	private DetalleKitProductoDao detalleKitProductoDao;

	@Override
	@Transactional(readOnly = true)
	public List<DetalleKitHerramienta> findAll() {
		return (List<DetalleKitHerramienta>)detalleKitProductoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleKitHerramienta findById(Integer id) {
		return detalleKitProductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DetalleKitHerramienta save(DetalleKitHerramienta detalleKitProducto) {
		return detalleKitProductoDao.save(detalleKitProducto);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		detalleKitProductoDao.deleteById(id);
	}

}
