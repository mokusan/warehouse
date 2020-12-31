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

import com.jcry.warehouse.model.Cliente;
import com.jcry.warehouse.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> lista = clienteService.listarTodo();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id) {
		Cliente cliente = clienteService.buscarPorId(id);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {
		Cliente fab = clienteService.registrar(cliente);
		return new ResponseEntity<Cliente>(fab, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> modificar(@RequestBody Cliente cliente) {
		Cliente fab = clienteService.modificar(cliente);
		return new ResponseEntity<Cliente>(fab, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = clienteService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
