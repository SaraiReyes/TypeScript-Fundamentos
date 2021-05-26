package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.BitacoraEntradaDao;
import mb.backend.apirest.capacitacion.entity.BitacoraEntrada;

@Service
public class BitacoraEntradaServiceImp implements BitacoraEntradaService{
	
	@Autowired
	private BitacoraEntradaDao bitacoraEntradaDao;

	@Override
	@Transactional(readOnly = true)
	public List<BitacoraEntrada> findAll() {
		return (List<BitacoraEntrada>)bitacoraEntradaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public BitacoraEntrada findById(Integer id) {
		return bitacoraEntradaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public BitacoraEntrada save(BitacoraEntrada bitacoraEntrada) {
		return bitacoraEntradaDao.save(bitacoraEntrada);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		bitacoraEntradaDao.deleteById(id);
	}

}
