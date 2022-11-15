package com.squad33.api.service;

import java.util.List;

import com.squad33.api.models.Usuario;

public interface IUsuarioService {

	public Usuario save(Usuario usuario);
	
	public List<Usuario> findAll();

	public Usuario findById(Integer id);
	
	public Usuario findByUsername(String username);
	
}
