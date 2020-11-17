package com.jcry.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tienda")
public class Tienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_tienda, nullable = false)
	private Integer idTienda;
		
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "direccion", nullable = false, unique = true)
	private String direccion;

	public Tienda() {
	}

	public Tienda(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Tienda [idTienda=" + idTienda + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
}
