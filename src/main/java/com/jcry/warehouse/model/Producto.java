package com.jcry.warehouse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_producto", nullable = false)
	private Integer idProducto;	
	
	@ApiModelProperty(notes = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Size(min = 2, message = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	
	@ApiModelProperty(notes = "El campo \"precio\" debe tener al menos 1 caracteres")
	@Size(min = 1, message = "El campo \"precio\" debe tener al menos 1 caracteres")
	@Column(name = "precio", nullable = false, unique = false)
	private String precio;
	
	@ManyToOne
    private Fabricante fabricante;
	
	@OneToMany(mappedBy = "producto")
	private List<Inventario> inventario;
	
	@OneToMany(mappedBy = "producto")
	private List<VentasDetalles> ventasDetalles;
		
	public Producto() {
	}

	public Producto(String nombre, String precio, Fabricante fabricante) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Productos [idProducto=" + idProducto + ", nombre=" + nombre
				+ ", precio=" + precio + ", fabricante=" + fabricante + "]";
	}	
}
