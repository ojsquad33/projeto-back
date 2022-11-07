package com.squad33.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.squad33.api.sevice.impl.AlunoServiceImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AlunoServiceImpl alunoService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth
		.userDetailsService(alunoService)
		.passwordEncoder(passwordEncoder())
		.and()
		.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder())
		.withUser("adm")
		.password(passwordEncoder().encode("adm123"))
		.roles("ADM");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/alunos/signup").permitAll()
		.antMatchers("/api/aulas").authenticated()
		.antMatchers("/api/cursos").authenticated()
		.antMatchers("/api/trilhas").authenticated()
		.antMatchers(HttpMethod.PUT,"/api/alunos/**").hasRole("USER")
		.antMatchers("/api/alunos/**").hasRole("ADM")
		.antMatchers("api/administrador/aulas/**").hasRole("ADM")
		.antMatchers("api/administrador/cursos/**").hasRole("ADM")
		.antMatchers("api/administrador/trilhas/**").hasRole("ADM")
		.and().httpBasic();
	}
}
