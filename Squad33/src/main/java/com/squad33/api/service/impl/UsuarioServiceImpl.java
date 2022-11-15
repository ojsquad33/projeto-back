package com.squad33.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.squad33.api.error.ResourceAlreadyExistsException;
import com.squad33.api.error.ResourceNotFoundException;
import com.squad33.api.error.SenhaInvalidaException;
import com.squad33.api.models.Usuario;
import com.squad33.api.repositories.UsuarioRepository;
import com.squad33.api.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository repository;

	public UserDetails autenticar(Usuario usuario) {
		UserDetails user = loadUserByUsername(usuario.getUsername());
		boolean senhasBatem = passwordEncoder.matches(usuario.getSenha(), user.getPassword());
		
		if(!senhasBatem) {
			throw new SenhaInvalidaException();
		}
		
		
		return user;
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = findByUsername(username);
				
		String[] roles = 
				usuario.isAdmin() ? new String[] { "ADM", "USER" } : new String[] { "USER" };

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
			throw new ResourceAlreadyExistsException("Username já existente");
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
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
	}

	@Override
	public Usuario findByUsername(String username) {
		return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
	}

	

}
