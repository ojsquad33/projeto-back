package com.squad33.api.sevice;

import java.util.List;

import com.squad33.api.models.Usuario;

public interface IUsuarioService {

	public Usuario save(Usuario usuario);
	
	public Usuario update(Usuario usuario,Integer id);

	public List<Usuario> findAll();

	public Usuario findById(Integer id);
	
	public Usuario findByUsername(String username);
	
}
