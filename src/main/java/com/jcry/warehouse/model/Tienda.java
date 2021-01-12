package com.jcry.warehouse.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tienda")
public class Tienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_tienda, nullable = false)
	private Integer idTienda;
		
	@ApiModelProperty(notes = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Size(min = 2, message = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	
	@ApiModelProperty(notes = "El campo \"direccion\" debe tener al menos 2 caracteres")
	@Size(min = 3, message = "El campo \"direccion\" debe tener al menos 3 caracteres")
	@Column(name = "direccion", nullable = false, unique = false)
	private String direccion;
	
	@OneToMany(mappedBy = "tienda")
	private List<Inventario> inventario;
	
	@OneToMany(mappedBy = "tienda")
	private List<Ventas> ventas;

	public Tienda() {
	}

	public Tienda(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
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
}
