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
@Table(name="detalle_kit_herramienta")
public class DetalleKitHerramienta implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_kits_producto")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private KitHerramienta kitsProducto;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="producto")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Kit producto;
	
	private int cantidad;
	
	@Column(name = "estatus")
	private String status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public KitHerramienta getKitsProducto() {
		return kitsProducto;
	}

	public void setKitsProducto(KitHerramienta kitsProducto) {
		this.kitsProducto = kitsProducto;
	}

	public Kit getProducto() {
		return producto;
	}

	public void setProducto(Kit producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private static final long serialVersionUID = 1L;
}
