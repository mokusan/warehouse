package com.jcry.warehouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcry.warehouse.dto.ProductoTiendaDTO;
import com.jcry.warehouse.model.Inventario;
import com.jcry.warehouse.service.InventarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;
		
	@ApiOperation(value = "Obtener todos los Inventarios",
		    notes = "No requiere parametros de entrada",
		    response = Inventario.class,
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
	public ResponseEntity<List<Inventario>> listar() {
		List<Inventario> lista = inventarioService.listarTodo();
		return new ResponseEntity<List<Inventario>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Inventario por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Inventario.class,
		    responseContainer = "Inventario")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Inventario> listarPorId(@PathVariable("id") Integer id) {
		Inventario inventario = inventarioService.buscarPorId(id);
		return new ResponseEntity<Inventario>(inventario, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Inventario",
		    notes = "Requiere un Inventario nuevo como entrada",
		    response = Inventario.class,
		    responseContainer = "Inventario")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Inventario> registrar(@RequestBody Inventario invricante) {
		Inventario inv = inventarioService.registrar(invricante);
		return new ResponseEntity<Inventario>(inv, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Inventario",
		    notes = "Requiere un Inventario pre-existente como entrada",
		    response = Inventario.class,
		    responseContainer = "Inventario")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, Inventario no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Inventario> modificar(@RequestBody Inventario invricante) {
		Inventario inv = inventarioService.modificar(invricante);
		return new ResponseEntity<Inventario>(inv, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Inventario",
		    notes = "Requiere un ID de Inventario como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID de Inventario no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Boolean inv = inventarioService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Obtener todos los Inventarios",
		    notes = "DTO",
		    response = ProductoTiendaDTO.class,
		    responseContainer = "List")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductoTiendaDTO> listarHateoas() {
		List<Inventario> stock = new ArrayList<>();
		List<ProductoTiendaDTO> productoTiendaDTO = new ArrayList<>();
		stock = inventarioService.listarTodo();

		for (Inventario i : stock) {
			ProductoTiendaDTO productoTienda = new ProductoTiendaDTO();
			productoTienda.setIdInventario(i.getIdInventario());
			productoTienda.setProducto(i.getProducto());
			productoTienda.setTienda(i.getTienda());

			// localhost:8080/consultas/1
			WebMvcLinkBuilder linkTo = linkTo(methodOn(InventarioController.class).listarPorId((i.getIdInventario())));
			productoTienda.add(linkTo.withSelfRel());
			
			// localhost:0880/paciente/1
			WebMvcLinkBuilder linkTo1 = linkTo(methodOn(ProductoController.class).listarPorId((i.getProducto().getIdProducto())));
			productoTienda.add(linkTo1.withSelfRel());

			WebMvcLinkBuilder linkTo2 = linkTo(methodOn(TiendaController.class).listarPorId((i.getTienda().getIdTienda())));
			productoTienda.add(linkTo2.withSelfRel());
			productoTiendaDTO.add(productoTienda);
		}
		return productoTiendaDTO;
	}
}
