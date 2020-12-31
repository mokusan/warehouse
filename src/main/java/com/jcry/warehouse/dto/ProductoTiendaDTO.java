package com.jcry.warehouse.dto;

import org.springframework.hateoas.RepresentationModel;

import com.jcry.warehouse.model.Producto;
import com.jcry.warehouse.model.Tienda;

// DTO para HATEOAS de inventario
public class ProductoTiendaDTO extends RepresentationModel<ProductoTiendaDTO> {
	
	private Integer idInventario;
	private Producto producto;
	private Tienda tienda;
	public Integer getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
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
}
