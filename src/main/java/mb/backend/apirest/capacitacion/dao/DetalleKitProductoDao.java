package mb.backend.apirest.capacitacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.backend.apirest.capacitacion.entity.DetalleKitHerramienta;

public interface DetalleKitProductoDao extends JpaRepository<DetalleKitHerramienta, Integer>{

}
