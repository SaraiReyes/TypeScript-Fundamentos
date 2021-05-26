package mb.backend.apirest.capacitacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.backend.apirest.capacitacion.entity.Prenda;

public interface PrendaDao extends JpaRepository<Prenda, Integer>{

}
