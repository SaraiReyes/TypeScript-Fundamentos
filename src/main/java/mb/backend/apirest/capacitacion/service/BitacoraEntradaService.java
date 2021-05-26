package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.BitacoraEntrada;

public interface BitacoraEntradaService {
	
	public List<BitacoraEntrada> findAll();
	public BitacoraEntrada findById(Integer id);
	public BitacoraEntrada save(BitacoraEntrada bitacoraEntrada);
	public void delete(Integer id);

}
