package com.squad33.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.squad33.api.models.Usuario;
import com.squad33.api.sevice.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	// Ver 04.11.2022 - > @ExceptionHandler
	public Usuario findById(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}

	@PostMapping("/signup")
	public ResponseEntity<Object> save(@RequestBody @Valid Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}

	@PutMapping("/{id}")
	public Object update(@RequestBody @Valid Usuario usuario, @PathVariable Integer id) {
		findById(id);
		usuario.setId(id);
		return save(usuario);
		
	}
}
