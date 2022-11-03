package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Aluno;
import com.squad33.api.repositories.AlunoRepository;
import com.squad33.api.sevice.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{


	@Autowired
	private AlunoRepository repository;
	
	@Override
	public Aluno save(Aluno aluno) {
		return repository.save(aluno);
	}
	
	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
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
