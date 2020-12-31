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

import com.jcry.warehouse.model.VentasDetalles;
import com.jcry.warehouse.service.VentasDetallesService;

@RestController
@RequestMapping("/venta-detalle")
public class VentasDetallesController {

	@Autowired
	private VentasDetallesService ventasDetallesService;
	
	@GetMapping
	public ResponseEntity<List<VentasDetalles>> listar() {
		List<VentasDetalles> lista = ventasDetallesService.listarTodo();
		return new ResponseEntity<List<VentasDetalles>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VentasDetalles> listarPorId(@PathVariable("id") Integer id) {
		VentasDetalles ventasDetalles = ventasDetallesService.buscarPorId(id);
		return new ResponseEntity<VentasDetalles>(ventasDetalles, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<VentasDetalles> registrar(@RequestBody VentasDetalles ventasDetalles) {
		VentasDetalles fab = ventasDetallesService.registrar(ventasDetalles);
		return new ResponseEntity<VentasDetalles>(fab, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<VentasDetalles> modificar(@RequestBody VentasDetalles ventasDetalles) {
		VentasDetalles fab = ventasDetallesService.modificar(ventasDetalles);
		return new ResponseEntity<VentasDetalles>(fab, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = ventasDetallesService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
