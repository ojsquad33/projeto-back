package com.squad33.api.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

		//String authorization = request.getHeader("Authorization");

		Cookie[] cookies = request.getCookies();
		String token = "";

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				String value = cookies[i].getValue();
				if(name.equals("Authorization")) {
					response.addHeader(name, "Bearer ".concat(value));
					token = value;
				}
			}
		}


		boolean tokenValido = jwtService.tokenValido(token);

		if (tokenValido) {
			String usernameUsuario = jwtService.obterUsernameUsuario(token);
			UserDetails usuario = usuarioService.loadUserByUsername(usernameUsuario);
			UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usernameUsuario, null,
					usuario.getAuthorities());

			user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(user);

		}

		filterChain.doFilter(request, response);
	}
}
