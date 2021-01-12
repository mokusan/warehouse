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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/venta")
public class VentasController {

	@Autowired
	private VentasService ventasService;
	
	@ApiOperation(value = "Obtener todos los Ventass",
		    notes = "No requiere parametros de entrada",
		    response = Ventas.class,
		    responseContainer = "List")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping
	public ResponseEntity<List<Ventas>> listar() {
		List<Ventas> lista = ventasService.listarTodo();
		return new ResponseEntity<List<Ventas>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Ventas por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Ventas.class,
		    responseContainer = "Ventas")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Ventas> listarPorId(@PathVariable("id") Integer id) {
		Ventas ventas = ventasService.buscarPorId(id);
		return new ResponseEntity<Ventas>(ventas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Ventas",
		    notes = "Requiere un Ventas nuevo como entrada",
		    response = Ventas.class,
		    responseContainer = "Ventas")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Ventas> registrar(@RequestBody Ventas ventas) {
		Ventas fab = ventasService.registrar(ventas);
		return new ResponseEntity<Ventas>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Ventas pre-existente",
		    notes = "Requiere un Ventas pre-existente como entrada",
		    response = Ventas.class,
		    responseContainer = "Ventas")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, Ventas no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Ventas> modificar(@RequestBody Ventas ventas) {
		Ventas fab = ventasService.modificar(ventas);
		return new ResponseEntity<Ventas>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Ventas",
		    notes = "Requiere un ID de Ventas como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID de Ventas no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = ventasService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
