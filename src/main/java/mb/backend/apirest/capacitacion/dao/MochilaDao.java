package mb.backend.apirest.capacitacion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mb.backend.apirest.capacitacion.entity.Mochila;

public interface MochilaDao extends JpaRepository<Mochila, Integer>{
	
	List<Mochila> findByStatus(@Param("status") String status);
	
}
