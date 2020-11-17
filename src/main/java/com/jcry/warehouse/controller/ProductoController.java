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

import com.jcry.warehouse.model.Producto;
import com.jcry.warehouse.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;	
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar() {
		List<Producto> lista = productoService.listarTodo();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) {
		Producto producto = productoService.buscarPorId(id);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
		Producto prod = productoService.registrar(producto);
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
		Producto prod = productoService.modificar(producto);
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean prod = productoService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
