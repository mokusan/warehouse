package com.jcry.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcry.warehouse.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

}
