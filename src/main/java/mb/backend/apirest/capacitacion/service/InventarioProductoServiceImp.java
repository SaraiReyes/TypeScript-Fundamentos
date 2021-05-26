package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.InventarioProductoDao;
import mb.backend.apirest.capacitacion.entity.InventarioProducto;

@Service
public class InventarioProductoServiceImp implements InventarioProductoService{
	
	@Autowired
	private InventarioProductoDao inventarioProductoDao;

	@Override
	@Transactional(readOnly = true)
	public List<InventarioProducto> findAll() {
		return (List<InventarioProducto>)inventarioProductoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public InventarioProducto findById(Integer id) {
		return inventarioProductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public InventarioProducto save(InventarioProducto inventarioProducto) {
		return inventarioProductoDao.save(inventarioProducto);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		inventarioProductoDao.deleteById(id);
	}

}
