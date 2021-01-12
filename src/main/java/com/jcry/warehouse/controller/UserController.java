package com.jcry.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.jcry.warehouse.exceptions.AuthException;
import com.jcry.warehouse.exceptions.ModelException;
//import com.jcry.warehouse.exceptions.NotAuthorizedException;
import com.jcry.warehouse.model.Usuario;
import com.jcry.warehouse.service.IUsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	private IUsuarioService userService;
	
//	@GetMapping // No funca
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	public ResponseEntity<List<Usuario>> listar(){
//		List<Usuario> lista = userService.listarTodo();
//		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
//	}
	
	@ApiOperation(value = "Obtener todos los Usuarios",
		    notes = "No requiere parametros de entrada",
		    response = Usuario.class,
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
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> lista = userService.listarTodo();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Obtener todos los Usuarios",
		    notes = "No requiere parametros de entrada",
		    response = Usuario.class,
		    responseContainer = "List")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/getAll")
	public ResponseEntity<List<Usuario>> getAll() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
			List<Usuario> lista = userService.listarTodo();
			return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
		} else {
			List<Usuario> lista = null;
			return new ResponseEntity<List<Usuario>>(lista, HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	@ApiOperation(value = "Buscar Usuario por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Usuario.class,
		    responseContainer = "Usuario")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 401, message = "Unauthorized, Token inválido o caducado"),
			 @ApiResponse(code = 403, message = "Forbidden, su usuario tiene prohibido el acceso a esta URL"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
			Usuario obj = userService.buscarPorId(id);
			if(obj.getIdUsuario() == null) {
				throw new ModelException("ID NO ENCONTRADO " + id);
			}
			return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.UNAUTHORIZED);
		}
		
	}

}