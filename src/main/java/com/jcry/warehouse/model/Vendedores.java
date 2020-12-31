package com.jcry.warehouse.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVendedor;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "venderdores")
	private List<Ventas> ventas;

	public Vendedores() {
	}

	public Vendedores(Integer idVendedor, String nombre) {
		this.idVendedor = idVendedor;
		this.nombre = nombre;
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Vendedores [idVendedor=" + idVendedor + ", nombre=" + nombre + "]";
	}
}
