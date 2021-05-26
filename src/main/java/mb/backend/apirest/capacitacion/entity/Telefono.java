package mb.backend.apirest.capacitacion.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="telefono")
public class Telefono implements Serializable{
	
	@Id
	private Integer numSerie;

	private float precio;
	
	private String IMEI;
	
	@Column(name = "estatus")
	private String status;
	
	private String disponible;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_estado_telefono")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private EstadoTelefono estadoTelefono;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_linea_telefono")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private LineaTelefono lineaTelefono;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_modelo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Modelo modelo;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_activo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Herramienta activo;
	
	public Integer getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(Integer numSerie) {
		this.numSerie = numSerie;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public EstadoTelefono getEstadoTelefono() {
		return estadoTelefono;
	}

	public void setEstadoTelefono(EstadoTelefono estadoTelefono) {
		this.estadoTelefono = estadoTelefono;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LineaTelefono getLineaTelefono() {
		return lineaTelefono;
	}

	public void setLineaTelefono(LineaTelefono lineaTelefono) {
		this.lineaTelefono = lineaTelefono;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public Herramienta getActivo() {
		return activo;
	}

	public void setActivo(Herramienta activo) {
		this.activo = activo;
	}

	private static final long serialVersionUID = 1L;
}
