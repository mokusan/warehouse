package com.jcry.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Cliente;
import com.jcry.warehouse.model.Tienda;
import com.jcry.warehouse.repository.ClientesRepository;
import com.jcry.warehouse.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClientesRepository repo;

	@Override
	public Cliente registrar(Cliente obj) {
		return repo.save(obj);
	}

	@Override
	public Cliente modificar(Cliente obj) {
		return repo.save(obj);
	}

	@Override
	public List<Cliente> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> cliente = repo.findById(id);
		if (!cliente.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			return cliente.get();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		Optional<Cliente> cliente = repo.findById(id);
		if (!cliente.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			repo.deleteById(id);
			return true;
		}
	}
}
