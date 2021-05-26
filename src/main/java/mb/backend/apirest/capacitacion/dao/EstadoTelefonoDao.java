package mb.backend.apirest.capacitacion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mb.backend.apirest.capacitacion.entity.EstadoTelefono;

public interface EstadoTelefonoDao extends JpaRepository<EstadoTelefono, Integer>{
	
	List<EstadoTelefono> findByStatus(@Param("status") String status);

}
