package mb.backend.apirest.capacitacion.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="inventario_producto")
public class InventarioProducto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cantidad_minima")
	private int cantidadMin;
	
	@Column(name = "cantidad_existente")
	private int cantidadExistente;
	
	private Integer usados;
	
	private Integer nuevos;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_kit")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Kit kit;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_herramienta")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Herramienta herramienta;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantidadMin() {
		return cantidadMin;
	}

	public void setCantidadMin(int cantidadMin) {
		this.cantidadMin = cantidadMin;
	}

	public int getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

	public Integer getUsados() {
		return usados;
	}

	public void setUsados(Integer usados) {
		this.usados = usados;
	}

	public Integer getNuevos() {
		return nuevos;
	}

	public void setNuevos(Integer nuevos) {
		this.nuevos = nuevos;
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

	private static final long serialVersionUID = 1L;
}
