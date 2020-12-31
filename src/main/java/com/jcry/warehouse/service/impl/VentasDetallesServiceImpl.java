package com.jcry.warehouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.VentasDetalles;
import com.jcry.warehouse.repository.VendedoresRepository;
import com.jcry.warehouse.repository.VentasDetallesRepository;
import com.jcry.warehouse.service.VentasDetallesService;

@Service
public class VentasDetallesServiceImpl implements VentasDetallesService {
	
	@Autowired
	private VentasDetallesRepository repo;

	@Override
	public VentasDetalles registrar(VentasDetalles obj) {
		return repo.save(obj);
	}

	@Override
	public VentasDetalles modificar(VentasDetalles obj) {
		return repo.save(obj);
	}

	@Override
	public List<VentasDetalles> listarTodo() {
		return repo.findAll();
	}

	@Override
	public VentasDetalles buscarPorId(Integer id) {
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
