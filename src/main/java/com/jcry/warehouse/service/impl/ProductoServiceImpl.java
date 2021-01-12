package com.jcry.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Producto;
import com.jcry.warehouse.repository.ProductoRepository;
import com.jcry.warehouse.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Producto registrar(Producto obj) {
		return repo.save(obj);
	}

	@Override
	public Producto modificar(Producto obj) {
		return repo.save(obj);
	}

	@Override
	public List<Producto> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Producto buscarPorId(Integer id) {
		Optional<Producto> producto = repo.findById(id);
		if (!producto.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			return producto.get();
		}	
	}

	@Override
	public boolean eliminar(Integer id) {
		Optional<Producto> producto = repo.findById(id);
		if (!producto.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			repo.deleteById(id);
			return true;
		}
	}
}
