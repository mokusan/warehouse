package com.jcry.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcry.warehouse.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);
}