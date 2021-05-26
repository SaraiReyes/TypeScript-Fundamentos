package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.backend.apirest.capacitacion.dao.DetalleInvetarioDao;
import mb.backend.apirest.capacitacion.entity.DetalleInvetario;

@Service
public class DetalleInvetarioServiceImp implements DetalleInvetarioService {

	@Autowired
	private DetalleInvetarioDao detalleInvetarioDao;
	
	@Override
	public List<DetalleInvetario> findAll() {
		return detalleInvetarioDao.findAll();
	}

	@Override
	public DetalleInvetario findById(Integer id) {
		return detalleInvetarioDao.findById(id).orElse(null);
	}

	@Override
	public DetalleInvetario save(DetalleInvetario inventario) {
		return detalleInvetarioDao.save(inventario);
	}

	@Override
	public void delete(Integer id) {
		detalleInvetarioDao.deleteById(id);
	}

}
