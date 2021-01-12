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

import com.jcry.warehouse.model.Fabricante;
import com.jcry.warehouse.service.FabricanteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteService fabricanteService;
	
	@ApiOperation(value = "Obtener todos los Fabricantes",
		    notes = "No requiere parametros de entrada",
		    response = Fabricante.class,
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
	public ResponseEntity<List<Fabricante>> listar() {
		List<Fabricante> lista = fabricanteService.listarTodo();
		return new ResponseEntity<List<Fabricante>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Fabricante por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Fabricante.class,
		    responseContainer = "Fabricante")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Fabricante> listarPorId(@PathVariable("id") Integer id) {
		Fabricante fabricante = fabricanteService.buscarPorId(id);
		return new ResponseEntity<Fabricante>(fabricante, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Fabricante",
		    notes = "Requiere un Fabricante nuevo como entrada",
		    response = Fabricante.class,
		    responseContainer = "Fabricante")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Fabricante> registrar(@RequestBody Fabricante fabricante) {
		Fabricante fab = fabricanteService.registrar(fabricante);
		return new ResponseEntity<Fabricante>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Fabricante pre-existente",
		    notes = "Requiere un Fabricante pre-existente como entrada",
		    response = Fabricante.class,
		    responseContainer = "Fabricante")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, Fabricante no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Fabricante> modificar(@RequestBody Fabricante fabricante) {
		Fabricante fab = fabricanteService.modificar(fabricante);
		return new ResponseEntity<Fabricante>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Fabricante",
		    notes = "Requiere un ID de Fabricante como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID de Fabricante no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = fabricanteService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
