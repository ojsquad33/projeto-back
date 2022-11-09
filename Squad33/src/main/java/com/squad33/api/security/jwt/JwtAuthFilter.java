package com.squad33.api.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.squad33.api.sevice.impl.UsuarioServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

	private JwtService jwtService;
	private UsuarioServiceImpl usuarioService;

	public JwtAuthFilter(JwtService jwtService, UsuarioServiceImpl usuarioService) {
		super();
		this.jwtService = jwtService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorization = request.getHeader("Authorization");

		if (authorization != null && authorization.startsWith("Bearer ")) {
			String token = authorization.split(" ")[1];

			boolean tokenValido = jwtService.tokenValido(token);

			if (tokenValido) {
				String usernameUsuario = jwtService.obterUsernameUsuario(token);
				UserDetails usuario = usuarioService.loadUserByUsername(usernameUsuario);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usernameUsuario,
						null, usuario.getAuthorities());
				
				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(user);
				
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
