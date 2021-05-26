package mb.backend.apirest.capacitacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import mb.backend.apirest.capacitacion.entity.DetalleInvetario;

public interface DetalleInvetarioDao extends JpaRepository<DetalleInvetario, Integer> {

}
