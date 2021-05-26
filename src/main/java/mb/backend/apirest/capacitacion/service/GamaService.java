package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Gama;

public interface GamaService {

	public List<Gama> findAll();
	public List<Gama> findStatus(String status);
	public Gama findById(Integer id);
	public Gama save(Gama Gama);
	public void delete(Integer id);
}
