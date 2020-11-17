package com.jcry.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcry.warehouse.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

}
