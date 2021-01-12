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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/venta-detalle")
public class VentasDetallesController {

	@Autowired
	private VentasDetallesService ventasDetallesService;
	
	@ApiOperation(value = "Obtener todos los VentasDetalles",
		    notes = "No requiere parametros de entrada",
		    response = VentasDetalles.class,
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
	public ResponseEntity<List<VentasDetalles>> listar() {
		List<VentasDetalles> lista = ventasDetallesService.listarTodo();
		return new ResponseEntity<List<VentasDetalles>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar VentasDetalles por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = VentasDetalles.class,
		    responseContainer = "VentasDetalles")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<VentasDetalles> listarPorId(@PathVariable("id") Integer id) {
		VentasDetalles ventasDetalles = ventasDetallesService.buscarPorId(id);
		return new ResponseEntity<VentasDetalles>(ventasDetalles, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo VentasDetalles",
		    notes = "Requiere un VentasDetalles nuevo como entrada",
		    response = VentasDetalles.class,
		    responseContainer = "VentasDetalles")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<VentasDetalles> registrar(@RequestBody VentasDetalles ventasDetalles) {
		VentasDetalles fab = ventasDetallesService.registrar(ventasDetalles);
		return new ResponseEntity<VentasDetalles>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar VentasDetalles pre-existente",
		    notes = "Requiere un VentasDetalles pre-existente como entrada",
		    response = VentasDetalles.class,
		    responseContainer = "VentasDetalles")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, VentasDetalles no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<VentasDetalles> modificar(@RequestBody VentasDetalles ventasDetalles) {
		VentasDetalles fab = ventasDetallesService.modificar(ventasDetalles);
		return new ResponseEntity<VentasDetalles>(fab, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar VentasDetalles",
		    notes = "Requiere un ID de VentasDetalles como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID de VentasDetalles no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean fab = ventasDetallesService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
