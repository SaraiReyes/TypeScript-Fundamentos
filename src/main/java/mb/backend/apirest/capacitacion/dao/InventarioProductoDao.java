package mb.backend.apirest.capacitacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.backend.apirest.capacitacion.entity.InventarioProducto;

public interface InventarioProductoDao extends JpaRepository<InventarioProducto, Integer>{

}
