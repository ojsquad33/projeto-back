package com.squad33.api.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.models.Trilha;
import com.squad33.api.repositories.TrilhaRepository;
import com.squad33.api.sevice.ITrilhaService;

@Service
public class TrilhaServiceImpl implements ITrilhaService {
	
	@Autowired
	private TrilhaRepository repository;

	@Override
	public Page<Trilha> getAll(Pageable pageable){
		return repository.findAll(pageable);
	}

	@Override
	public Trilha findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada, id inexistente."));
	}

	@Override
	public Trilha save(Trilha trilha) {
		return repository.save(trilha);
	}

	@Override
	public void deleteById(Integer id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada, id inexistente.");
		}
		repository.deleteById(id);
	}

	@Override
	public Trilha update(Integer id) {

		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada, id inexistente.");
		}
		Trilha trilha = repository.findById(id).orElse(null);
		return save(trilha);
	}
}
