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

import com.jcry.warehouse.model.Inventario;
import com.jcry.warehouse.service.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;
	
	@GetMapping
	public ResponseEntity<List<Inventario>> listar() {
		List<Inventario> lista = inventarioService.listarTodo();
		return new ResponseEntity<List<Inventario>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Inventario> listarPorId(@PathVariable("id") Integer id) {
		Inventario inventario = inventarioService.buscarPorId(id);
		return new ResponseEntity<Inventario>(inventario, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Inventario> registrar(@RequestBody Inventario invricante) {
		Inventario inv = inventarioService.registrar(invricante);
		return new ResponseEntity<Inventario>(inv, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Inventario> modificar(@RequestBody Inventario invricante) {
		Inventario inv = inventarioService.modificar(invricante);
		return new ResponseEntity<Inventario>(inv, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean inv = inventarioService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
