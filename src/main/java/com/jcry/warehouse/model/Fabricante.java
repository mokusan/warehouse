package com.jcry.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_fabricante", nullable = false)
	private Integer idFabricante;
	
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	
	public Fabricante() {
	}

	public Fabricante(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", nombre=" + nombre + "]";
	}
}
