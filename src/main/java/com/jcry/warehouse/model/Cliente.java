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
@Table(name = "cliente")
public class Cliente {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClientes;
	
	@Column(name = "telefono", nullable = false)
	private String telefono;	
	
	@Column(name = "nombre", nullable = false)
	private String nombre;	
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@OneToMany(mappedBy = "clientes")
	private List<Ventas> ventas;

	public Cliente() {
	}

	public Cliente(String telefono, String nombre, String direccion) {
		this.telefono = telefono;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Integer getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(Integer idClientes) {
		this.idClientes = idClientes;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return "Clientes [idClientes=" + idClientes + ", telefono=" + telefono + ", nombre=" + nombre + ", direccion="
				+ direccion + "]";
	}
}
