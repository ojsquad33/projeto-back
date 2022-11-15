package com.squad33.api.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.dto.CredenciaisDTO;
import com.squad33.api.dto.TokenDTO;
import com.squad33.api.dto.UsuarioDTO;
import com.squad33.api.error.SenhaInvalidaException;
import com.squad33.api.models.Usuario;
import com.squad33.api.security.jwt.JwtService;
import com.squad33.api.service.impl.UsuarioServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioServiceImpl usuarioService;
	private final JwtService jwtService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario findById(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO save(@RequestBody @Valid Usuario usuario) {
		usuarioService.save(usuario);
		return usuarioDTO(usuario);
	}

	@PostMapping("/auth")
	@ResponseStatus(HttpStatus.OK)
	public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciais, HttpServletResponse response) {
		try {
			boolean isAdmin = usuarioService.findByUsername(credenciais.getUsername()).isAdmin();
			Usuario usuario = Usuario.builder().username(credenciais.getUsername()).senha(credenciais.getSenha())
					.admin(isAdmin).build();
			UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
			String token = jwtService.gerarToken(usuario);

			Cookie cookie = new Cookie("Authorization", token);
			cookie.setPath("/");
			String[] roles = usuario.isAdmin() ? new String[] { "ADM", "USER" } : new String[] { "USER" };

			response.addCookie(cookie);

			return new TokenDTO(usuario.getUsername(), token, roles);
		} catch (UsernameNotFoundException | SenhaInvalidaException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public UsuarioDTO update(@RequestBody @Valid Usuario usuario, @PathVariable Integer id) {
		findById(id);
		usuario.setId(id);
		return save(usuario);

	}
	
	public UsuarioDTO usuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setUsername(usuario.getUsername());
		return usuarioDTO;
	}
}
