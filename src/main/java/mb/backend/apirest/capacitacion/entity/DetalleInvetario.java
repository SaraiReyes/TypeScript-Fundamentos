package mb.backend.apirest.capacitacion.entity;

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
@Table(name="detalle_invetario")
public class DetalleInvetario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_bitacora")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BitacoraEntrada idBitacora;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BitacoraEntrada getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(BitacoraEntrada idBitacora) {
		this.idBitacora = idBitacora;
	}

}
