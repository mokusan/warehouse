package com.jcry.warehouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Tienda;
import com.jcry.warehouse.repository.TiendaRepository;
import com.jcry.warehouse.service.TiendaService;

@Service
public class TiendaServiceImpl implements TiendaService {
	
	@Autowired
	private TiendaRepository repo;

	@Override
	public Tienda registrar(Tienda obj) {
		return repo.save(obj);
	}

	@Override
	public Tienda modificar(Tienda obj) {
		return repo.save(obj);
	}

	@Override
	public List<Tienda> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Tienda buscarPorId(Integer id) {
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
