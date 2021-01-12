package com.jcry.warehouse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_fabricante", nullable = false)
	private Integer idFabricante;
	
	@ApiModelProperty(notes = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Size(min = 2, message = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "fabricante")
	private List<Producto> productos;
	
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
