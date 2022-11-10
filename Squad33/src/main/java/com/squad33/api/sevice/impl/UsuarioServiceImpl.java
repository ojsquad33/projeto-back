package com.squad33.api.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.error.SenhaInvalidaException;
import com.squad33.api.models.Usuario;
import com.squad33.api.repositories.UsuarioRepository;
import com.squad33.api.sevice.IUsuarioService;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository repository;

	public UserDetails autenticar(Usuario usuario) {
		UserDetails user = loadUserByUsername(usuario.getUsername());
		boolean senhasBatem = passwordEncoder.matches(usuario.getSenha(), user.getPassword());
		
		if(senhasBatem) {
			return user;
		}
		
		throw new SenhaInvalidaException();
		
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		
		String[] roles = 
				usuario.isAdmin() ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };

		return User
				.builder()
				.username(usuario.getUsername())
				.password(usuario.getSenha())
				.roles(roles)
				.build();
	}

	@Override
	public Usuario save(Usuario usuario) {
		if (repository.existsByUsername(usuario.getUsername())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Username já existente");
		}
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return repository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();

	}

	@Override
	public Usuario findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
