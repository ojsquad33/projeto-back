package com.squad33.api.sevice.impl;

import java.util.List;

import com.squad33.api.sevice.ITrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.models.Curso;
import com.squad33.api.models.Trilha;
import com.squad33.api.repositories.TrilhaRepository;

@Service
public class TrilhaServiceImpl implements ITrilhaService {
	
	@Autowired
	private TrilhaRepository repository;

	public List<Trilha> getAll(){
		return repository.findAll();
	}

	@Override
	public Trilha findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Trilha save(Trilha trilha) {
		return repository.save(trilha);
	}

	@Override
	public void deleteById(Integer id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		repository.deleteById(id);
	}

	@Override
	public Trilha update(Integer id) {
		
		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Trilha trilha = repository.findById(id).orElse(null);
		return save(trilha);
	}

	@Override
	public Curso saveCurso(Curso curso) {
		
		return null;
	}

	
}
