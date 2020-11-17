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

import com.jcry.warehouse.model.Tienda;
import com.jcry.warehouse.service.TiendaService;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

	@Autowired
	private TiendaService tiendaService;
	
	
	@GetMapping
	public ResponseEntity<List<Tienda>> listar() {
		List<Tienda> lista = tiendaService.listarTodo();
		return new ResponseEntity<List<Tienda>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tienda> listarPorId(@PathVariable("id") Integer id) {
		Tienda tienda = tiendaService.buscarPorId(id);
		return new ResponseEntity<Tienda>(tienda, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Tienda> registrar(@RequestBody Tienda tienda) {
		Tienda ti = tiendaService.registrar(tienda);
		return new ResponseEntity<Tienda>(ti, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Tienda> modificar(@RequestBody Tienda tienda) {
		Tienda ti = tiendaService.modificar(tienda);
		return new ResponseEntity<Tienda>(ti, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean ti = tiendaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
