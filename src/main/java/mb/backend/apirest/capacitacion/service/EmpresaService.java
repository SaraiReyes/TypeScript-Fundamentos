package mb.backend.apirest.capacitacion.service;

import java.util.List;

import mb.backend.apirest.capacitacion.entity.Empresa;

public interface EmpresaService {
	
	public List<Empresa> findAll();
	public Empresa findById(Integer id);
	public Empresa save(Empresa empresa);
	public void delete(Integer id);

}
