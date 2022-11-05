package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import com.squad33.api.sevice.IAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Aula;
import com.squad33.api.repositories.AulaRepository;

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

}
