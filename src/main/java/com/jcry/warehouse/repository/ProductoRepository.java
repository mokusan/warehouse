package com.jcry.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcry.warehouse.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
	
}
