package com.jcry.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Ventas;
import com.jcry.warehouse.repository.VentasRepository;
import com.jcry.warehouse.service.VentasService;

@Service
public class VentasServiceImpl implements VentasService {
	
	@Autowired
	private VentasRepository repo;

	@Override
	public Ventas registrar(Ventas obj) {
		return repo.save(obj);
	}

	@Override
	public Ventas modificar(Ventas obj) {
		return repo.save(obj);
	}

	@Override
	public List<Ventas> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Ventas buscarPorId(Integer id) {
		Optional<Ventas> ventas = repo.findById(id);
		if (!ventas.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			return ventas.get();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		Optional<Ventas> ventas = repo.findById(id);
		if (!ventas.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			repo.deleteById(id);
			return true;
		}
	}
	
	

}
