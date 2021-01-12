package com.jcry.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Inventario;
import com.jcry.warehouse.repository.InventarioRepository;
import com.jcry.warehouse.service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService {

	@Autowired
	private InventarioRepository repo;
	
	@Override
	public Inventario registrar(Inventario obj) {
		return repo.save(obj);
	}

	@Override
	public Inventario modificar(Inventario obj) {
		return repo.save(obj);
	}

	@Override
	public List<Inventario> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Inventario buscarPorId(Integer id) {
		Optional<Inventario> inventario = repo.findById(id);
		if (!inventario.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			return inventario.get();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		Optional<Inventario> inventario = repo.findById(id);
		if (!inventario.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			repo.deleteById(id);
			return true;
		}
	}
	
}
