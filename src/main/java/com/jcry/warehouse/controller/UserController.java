package com.jcry.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcry.warehouse.exceptions.AuthException;
import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.exceptions.NotAuthorizedException;
import com.jcry.warehouse.model.Usuario;
import com.jcry.warehouse.service.IUsuarioService;

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