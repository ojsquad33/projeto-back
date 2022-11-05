package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.models.Aula;
import com.squad33.api.repositories.AulaRepository;
import com.squad33.api.sevice.IAulaService;

@Service
public class AulaServiceImpl implements IAulaService {

	@Autowired
	private AulaRepository repository;

	public Aula save(Aula aula) {
		return repository.save(aula);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void deleteAula(Aula aula) {
		repository.delete(aula);
	}

	public List<Aula> getAll() {
		return repository.findAll();
	}

	@Override
	public Aula findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Optional<Aula> FindById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Aula update(Integer id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Aula aula = repository.findById(id).orElse(null);
		return save(aula);
	}

}
