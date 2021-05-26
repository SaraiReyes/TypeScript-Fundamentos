package mb.backend.apirest.capacitacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.backend.apirest.capacitacion.entity.Kit;

public interface KitDao extends JpaRepository<Kit, Integer>{

}
