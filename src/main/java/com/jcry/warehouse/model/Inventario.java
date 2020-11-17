package com.jcry.warehouse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "inventario")
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_inventario", nullable = false)
	private Integer idInventario;	
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_inventario_producto"))
    private Producto producto;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tienda", nullable = false, foreignKey = @ForeignKey(name = "FK_inventario_tienda"))
    private Tienda tienda;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	public Inventario() {
	}

	public Inventario(Producto producto, Tienda tienda, Integer cantidad) {
		this.producto = producto;
		this.tienda = tienda;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Inventario [producto=" + producto + ", tienda=" + tienda + ", cantidad=" + cantidad + "]";
	}	
}
