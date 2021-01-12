package com.jcry.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Vendedores;
import com.jcry.warehouse.repository.VendedoresRepository;
import com.jcry.warehouse.service.VendedoresService;

@Service
public class VendedoresServiceImpl implements VendedoresService {
	
	@Autowired
	private VendedoresRepository repo;

	@Override
	public Vendedores registrar(Vendedores obj) {
		return repo.save(obj);
	}

	@Override
	public Vendedores modificar(Vendedores obj) {
		return repo.save(obj);
	}

	@Override
	public List<Vendedores> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Vendedores buscarPorId(Integer id) {
		Optional<Vendedores> vendedores = repo.findById(id);
		if (!vendedores.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			return vendedores.get();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		Optional<Vendedores> vendedores = repo.findById(id);
		if (!vendedores.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			repo.deleteById(id);
			return true;
		}
	}
}
