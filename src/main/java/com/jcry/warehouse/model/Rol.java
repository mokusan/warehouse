package com.jcry.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	private Integer idRol;
	
	@ApiModelProperty(notes = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Size(min = 2, message = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Column(name = "nombre")
	private String nombre;
	
	@ApiModelProperty(notes = "El campo \"descripcion\" debe tener al menos 2 caracteres")
	@Size(min = 2, message = "El campo \"descripcion\" debe tener al menos 2 caracteres")
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}