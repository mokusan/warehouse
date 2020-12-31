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

import com.jcry.warehouse.model.Vendedores;
import com.jcry.warehouse.service.VendedoresService;

@RestController
@RequestMapping("/vendedor")
public class VendedoresController {

	@Autowired
	private VendedoresService vendedoresService;
	
	@GetMapping
	public ResponseEntity<List<Vendedores>> listar() {
		List<Vendedores> lista = vendedoresService.listarTodo();
		return new ResponseEntity<List<Vendedores>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendedores> listarPorId(@PathVariable("id") Integer id) {
		Vendedores vendedores = vendedoresService.buscarPorId(id);
		return new ResponseEntity<Vendedores>(vendedores, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Vendedores> registrar(@RequestBody Vendedores vendedores) {
		Vendedores fab = vendedoresService.registrar(vendedores);
		return new ResponseEntity<Vendedores>(fab, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Vendedores> modificar(@RequestBody Vendedores vendedores) {
		Vendedores fab = vendedoresService.modificar(vendedores);
		return new ResponseEntity<Vendedores>(fab, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = vendedoresService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
