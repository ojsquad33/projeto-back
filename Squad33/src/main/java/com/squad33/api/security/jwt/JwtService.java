package com.squad33.api.security.jwt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	@Value("${security.jwt.expiracao}")
	private String expiracao;

	public String gerarToken(Usuario usuario) {
		long expString = Long.valueOf(expiracao);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);

		Date data = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant());

		return Jwts.builder().setSubject(usuario.getUsername()).setExpiration(data)
				.signWith(SignatureAlgorithm.HS512, chaveAssinatura).compact();
	}

	private Claims obterClaims(String token) throws ExpiredJwtException {
		return Jwts.parser().setSigningKey(chaveAssinatura).parseClaimsJws(token).getBody();
	}

	public boolean tokenValido(String token) {
		try {
			Claims claims = obterClaims(token);
			Date dataExpiracao = claims.getExpiration();
			LocalDateTime data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return !LocalDateTime.now().isAfter(data);
		} catch (Exception e) {
			return false;
		}
	}

	public String obterUsernameUsuario(String token) throws ExpiredJwtException {
		return (String) obterClaims(token).getSubject();
	}
	

}
