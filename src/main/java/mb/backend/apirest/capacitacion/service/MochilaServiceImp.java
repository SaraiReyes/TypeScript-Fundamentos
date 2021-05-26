package mb.backend.apirest.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mb.backend.apirest.capacitacion.dao.MochilaDao;
import mb.backend.apirest.capacitacion.entity.Mochila;

@Service
public class MochilaServiceImp implements MochilaService{
	
	@Autowired
	private MochilaDao mochilaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Mochila> findAll() {
		return (List<Mochila>)mochilaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mochila> findStatus(String status) {
		return (List<Mochila>)mochilaDao.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public Mochila findById(Integer id) {
		return mochilaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Mochila save(Mochila mochila) {
		return mochilaDao.save(mochila);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		mochilaDao.deleteById(id);
	}

}
