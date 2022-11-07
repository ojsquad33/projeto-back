package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.models.Aluno;
import com.squad33.api.repositories.AlunoRepository;
import com.squad33.api.sevice.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService, UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno save(Aluno aluno) {
        if (repository.existsByEmail(aluno.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já existente");
        }
        aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));
        return repository.save(aluno);
    }

    @Override
    public List<Aluno> getAll() {
        return repository.findAll();

    }

    @Override
    public Aluno FindById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public boolean existsByEmail(String email) {

        if(existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        } else {
            return false;
        }
    }

    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Aluno aluno = repository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado"));
		//System.out.println(aluno);
		if(!username.equals("aluno")) {
			throw new UsernameNotFoundException("Aluno não encontrado");
		}
		return User
				.builder()
				.username("aluno")
				.password(passwordEncoder.encode("aluno123"))
				.roles("USER")
				.build();
				
	}


}
