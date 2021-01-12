package com.jcry.warehouse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jcry.warehouse.exceptions.ModelException;
import com.jcry.warehouse.model.Usuario;
import com.jcry.warehouse.repository.UsuarioRepository;
import com.jcry.warehouse.service.IUsuarioService;

/**
 * A esta clase llega spring de forma automatica cuando se llama a la url de autenticacion, la que entrega el token
 * y verifica las credenciales
 * @author jcry
 *
 */
@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService {
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repo.findOneByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), roles);

		return ud;
	}

	@Override
	public Usuario registrar(Usuario obj) {
		return repo.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		return repo.save(obj);
	}

	@Override
	public List<Usuario> listarTodo() {
		return repo.findAll();
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> usuario = repo.findById(id);
		if (!usuario.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			return usuario.get();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		Optional<Usuario> usuario = repo.findById(id);
		if (!usuario.isPresent()) {
			throw new ModelException("Error: Registro con ID " + id + " no existe");
		} else {
			repo.deleteById(id);
			return true;
		}		
	}
}
