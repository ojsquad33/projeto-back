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
	@Override
	public Aula save(Aula aula) {
		return repository.save(aula);
	}
	@Override
	public void deleteById(Integer id) {
		if(!repository.existsById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada, id não existente.");
		} else {
			repository.deleteById(id);
		}
	}
	@Override
	public void deleteAula(Aula aula) {
		if(!repository.existsById(aula.getId())){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada, Id inexistente.");
		} else {
			repository.delete(aula);
		}
	}
	@Override
	public List<Aula> getAll() {
		return repository.findAll();
	}

	@Override
	public Aula findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada, id inexistente."));
	}

	@Override
	public Aula update(Integer id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada, id inexistente.");
		}
		Aula aula = repository.findById(id).orElse(null);
		return save(aula);
	}

}
