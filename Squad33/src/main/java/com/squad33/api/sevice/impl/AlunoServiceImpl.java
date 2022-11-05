package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.models.Aluno;
import com.squad33.api.repositories.AlunoRepository;
import com.squad33.api.sevice.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {


	@Autowired
	private AlunoRepository repository;
	
	@Override
	public Aluno save(Aluno aluno) {
		if(repository.existsByEmail(aluno.getEmail())) {
		throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já existente");
		}
		return repository.save(aluno);
	}

	@Override
	public List<Aluno> getAll(){
		return repository.findAll();
	}
	@Override
	public Optional<Aluno> FindById(Integer id){
		return repository.findById(id);
	}
	
	@Override
	public boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}

}
