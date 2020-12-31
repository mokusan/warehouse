package com.jcry.warehouse.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVentas;	
	
	@ManyToOne
    private Cliente clientes;
	
	@ManyToOne
    private Vendedores venderdores;

	@ManyToOne
    private Tienda tienda;
	
	@Column(name = "fecha", nullable = false)
	private String fecha;	
	
//	@Column(name = "monto", nullable = false)
//	private BigDecimal monto;
	
	@OneToMany(mappedBy = "venta")
	private List<VentasDetalles> ventasDetalles;

	public Ventas() {
	}

	public Ventas(Integer idVentas, Cliente clientes, Vendedores venderdores, Tienda tienda, String fecha) {
		this.idVentas = idVentas;
		this.clientes = clientes;
		this.venderdores = venderdores;
		this.tienda = tienda;
		this.fecha = fecha;
	}

	public Integer getIdVentas() {
		return idVentas;
	}

	public void setIdVentas(Integer idVentas) {
		this.idVentas = idVentas;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Vendedores getVenderdores() {
		return venderdores;
	}

	public void setVenderdores(Vendedores venderdores) {
		this.venderdores = venderdores;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
