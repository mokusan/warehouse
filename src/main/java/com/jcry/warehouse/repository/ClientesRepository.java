package com.jcry.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcry.warehouse.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer>{

}
