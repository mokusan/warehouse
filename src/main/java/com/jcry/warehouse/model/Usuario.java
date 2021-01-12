package com.jcry.warehouse.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	private Integer idUsuario;
	
	@ApiModelProperty(notes = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Size(min = 2, message = "El campo \"nombre\" debe tener al menos 2 caracteres")
	@Column(name = "nombre", nullable = false, unique = true)
	private String username;
	
	@ApiModelProperty(notes = "El campo \"clave\" debe tener al menos 3 caracteres")
	@Size(min = 3, message = "El campo \"clave\" debe tener al menos 3 caracteres")
	@Column(name = "clave", nullable = false)
	private String password;
	
	@ApiModelProperty(notes = "El campo \"estado\" debe tener al menos 2 caracteres")
	@Size(min = 2, message = "El campo \"estado\" debe tener al menos 2 caracteres")
	@Column(name = "estado", nullable = false)
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}