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

import com.jcry.warehouse.model.Ventas;
import com.jcry.warehouse.service.VentasService;

@RestController
@RequestMapping("/venta")
public class VentasController {

	@Autowired
	private VentasService ventasService;
	
	@GetMapping
	public ResponseEntity<List<Ventas>> listar() {
		List<Ventas> lista = ventasService.listarTodo();
		return new ResponseEntity<List<Ventas>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ventas> listarPorId(@PathVariable("id") Integer id) {
		Ventas ventas = ventasService.buscarPorId(id);
		return new ResponseEntity<Ventas>(ventas, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Ventas> registrar(@RequestBody Ventas ventas) {
		Ventas fab = ventasService.registrar(ventas);
		return new ResponseEntity<Ventas>(fab, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Ventas> modificar(@RequestBody Ventas ventas) {
		Ventas fab = ventasService.modificar(ventas);
		return new ResponseEntity<Ventas>(fab, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = ventasService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
