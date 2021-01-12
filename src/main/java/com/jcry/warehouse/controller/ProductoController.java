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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;	
	
	@ApiOperation(value = "Obtener todos los Productos",
		    notes = "No requiere parametros de entrada",
		    response = Producto.class,
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
	public ResponseEntity<List<Producto>> listar() {
		List<Producto> lista = productoService.listarTodo();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Producto por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Producto.class,
		    responseContainer = "Producto")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) {
		Producto producto = productoService.buscarPorId(id);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Producto",
		    notes = "Requiere un Producto nuevo como entrada",
		    response = Producto.class,
		    responseContainer = "Producto")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
		Producto prod = productoService.registrar(producto);
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Producto pre-existente",
		    notes = "Requiere un Producto pre-existente como entrada",
		    response = Producto.class,
		    responseContainer = "Producto")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, Producto no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
		Producto prod = productoService.modificar(producto);
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Producto",
		    notes = "Requiere un ID de Producto como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID de Producto no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean prod = productoService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
