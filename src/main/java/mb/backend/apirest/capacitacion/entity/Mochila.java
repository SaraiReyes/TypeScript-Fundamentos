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
@Table(name="mochila")
public class Mochila implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String tamano;
	
	@Column(name = "estatus")
	private String status;
	
	private String bordado;
	
	private String color;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_marca")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Marca marca;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_proveedor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Proveedor proveedor;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_activo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Herramienta activo;
	
	@ManyToOne(optional= false,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_empresa")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Empresa empresa;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBordado() {
		return bordado;
	}

	public void setBordado(String bordado) {
		this.bordado = bordado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Herramienta getActivo() {
		return activo;
	}

	public void setActivo(Herramienta activo) {
		this.activo = activo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	private static final long serialVersionUID = 1L;
}
