package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Mochila;

public interface MochilaService {
	
	public List<Mochila> findAll();
	public List<Mochila> findStatus(String status);
	public Mochila findById(Integer id);
	public Mochila save(Mochila mochila);
	public void delete(Integer id);

}
