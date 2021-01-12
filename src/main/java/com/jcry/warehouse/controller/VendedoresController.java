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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/vendedor")
public class VendedoresController {

	@Autowired
	private VendedoresService vendedoresService;
	
	@ApiOperation(value = "Obtener todos los Vendedores",
		    notes = "No requiere parametros de entrada",
		    response = Vendedores.class,
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
	public ResponseEntity<List<Vendedores>> listar() {
		List<Vendedores> lista = vendedoresService.listarTodo();
		return new ResponseEntity<List<Vendedores>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Vendedores por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Vendedores.class,
		    responseContainer = "Vendedores")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Vendedores> listarPorId(@PathVariable("id") Integer id) {
		Vendedores vendedores = vendedoresService.buscarPorId(id);
		return new ResponseEntity<Vendedores>(vendedores, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Vendedores",
		    notes = "Requiere un Vendedor nuevo como entrada",
		    response = Vendedores.class,
		    responseContainer = "Vendedores")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Vendedores> registrar(@RequestBody Vendedores vendedores) {
		Vendedores fab = vendedoresService.registrar(vendedores);
		return new ResponseEntity<Vendedores>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Vendedor pre-existente",
		    notes = "Requiere un Vendedor pre-existente como entrada",
		    response = Vendedores.class,
		    responseContainer = "Vendedores")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, Vendedores no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Vendedores> modificar(@RequestBody Vendedores vendedores) {
		Vendedores fab = vendedoresService.modificar(vendedores);
		return new ResponseEntity<Vendedores>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Vendedor",
		    notes = "Requiere un ID de Vendedor como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID de Vendedores no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = vendedoresService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
