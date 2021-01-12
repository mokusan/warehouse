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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

	@Autowired
	private TiendaService tiendaService;
	
	@ApiOperation(value = "Obtener todos los Tiendas",
		    notes = "No requiere parametros de entrada",
		    response = Tienda.class,
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
	public ResponseEntity<List<Tienda>> listar() {
		List<Tienda> lista = tiendaService.listarTodo();
		return new ResponseEntity<List<Tienda>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Tienda por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Tienda.class,
		    responseContainer = "Tienda")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Tienda> listarPorId(@PathVariable("id") Integer id) {
		Tienda tienda = tiendaService.buscarPorId(id);
		return new ResponseEntity<Tienda>(tienda, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Tienda",
		    notes = "Requiere un Tienda nuevo como entrada",
		    response = Tienda.class,
		    responseContainer = "Tienda")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Tienda> registrar(@RequestBody Tienda tienda) {
		Tienda ti = tiendaService.registrar(tienda);
		return new ResponseEntity<Tienda>(ti, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Tienda pre-existente",
		    notes = "Requiere un Tienda pre-existente como entrada",
		    response = Tienda.class,
		    responseContainer = "Tienda")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, Tienda no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Tienda> modificar(@RequestBody Tienda tienda) {
		Tienda ti = tiendaService.modificar(tienda);
		return new ResponseEntity<Tienda>(ti, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Tienda",
		    notes = "Requiere un ID de Tienda como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID de Tienda no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean ti = tiendaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
