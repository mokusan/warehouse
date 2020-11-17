package com.jcry.warehouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Fabricante;
import com.jcry.warehouse.repository.FabricanteRepository;
import com.jcry.warehouse.service.FabricanteService;

@Service
public class FabricanteServiceImpl implements FabricanteService {
	
	@Autowired
	private FabricanteRepository repo;

	@Override
	public Fabricante registrar(Fabricante obj) {
		return repo.save(obj);
	}

	@Override
	public Fabricante modificar(Fabricante obj) {
		return repo.save(obj);
	}

	@Override
	public List<Fabricante> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Fabricante buscarPorId(Integer id) {
		if (repo.findById(id).get() == null) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			return repo.findById(id).get();
		}		
	}

	@Override
	public boolean eliminar(Integer id) {
		if (repo.findById(id).get() == null) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			repo.deleteById(id);
			return true;
		}	
	}

}
