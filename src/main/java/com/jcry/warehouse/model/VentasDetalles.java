package com.jcry.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas_detalles")
public class VentasDetalles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVentaDetalle;	
	
	@ManyToOne
    private Producto producto;
	
	@ManyToOne
    private Ventas venta;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	public VentasDetalles() {
	}

	public VentasDetalles(Integer idVentaDetalle, Ventas venta, Integer cantidad) {
		this.idVentaDetalle = idVentaDetalle;
		this.venta = venta;
		this.cantidad = cantidad;
	}

	public Integer getIdVentaDetalle() {
		return idVentaDetalle;
	}

	public void setIdVentaDetalle(Integer idVentaDetalle) {
		this.idVentaDetalle = idVentaDetalle;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Ventas getVenta() {
		return venta;
	}

	public void setVenta(Ventas venta) {
		this.venta = venta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
