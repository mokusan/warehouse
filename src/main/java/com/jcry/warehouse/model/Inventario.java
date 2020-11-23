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

@Entity
@Table(name = "inventario")
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_inventario", nullable = false)
	private Integer idInventario;	
	
	@ManyToOne
//	(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Producto producto;
	
	@ManyToOne
//	(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Tienda tienda;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;	

	public Inventario() {
	}	

	public Inventario(Integer cantidad) {		
		this.cantidad = cantidad;
	}	
	
	public Integer getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
