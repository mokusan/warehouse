package com.jcry.warehouse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_producto", nullable = false)
	private Integer idProducto;	
	
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "precio", nullable = false, unique = true)
	private String precio;
	
	@ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fabricante", nullable = false, foreignKey = @ForeignKey(name = "FK_productos_fabricante"))
    private Fabricante fabricante;
		
	public Producto() {
	}

	public Producto(String nombre, String precio, Fabricante fabricante) {
		this.nombre = nombre;
		this.precio = precio;
		this.fabricante = fabricante;
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
