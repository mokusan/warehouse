package com.jcry.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcry.warehouse.model.Fabricante;
import com.jcry.warehouse.service.FabricanteService;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteService fabricanteService;
	
	@GetMapping
	public ResponseEntity<List<Fabricante>> listar() {
		List<Fabricante> lista = fabricanteService.listarTodo();
		return new ResponseEntity<List<Fabricante>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fabricante> listarPorId(@PathVariable("id") Integer id) {
		Fabricante fabricante = fabricanteService.buscarPorId(id);
		return new ResponseEntity<Fabricante>(fabricante, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Fabricante> registrar(@RequestBody Fabricante fabricante) {
		Fabricante fab = fabricanteService.registrar(fabricante);
		return new ResponseEntity<Fabricante>(fab, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Fabricante> modificar(@RequestBody Fabricante fabricante) {
		Fabricante fab = fabricanteService.modificar(fabricante);
		return new ResponseEntity<Fabricante>(fab, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = fabricanteService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
