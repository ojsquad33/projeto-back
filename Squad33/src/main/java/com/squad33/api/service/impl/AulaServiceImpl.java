package com.squad33.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.error.ResourceNotFoundException;
import com.squad33.api.models.Aula;
import com.squad33.api.repositories.AulaRepository;
import com.squad33.api.service.IAulaService;

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
		if (repository.findById(id) != null) {
			repository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Aula não encontrada, Id inexistente.");
		}
	}

	@Override
	public void deleteAula(Aula aula) {
		if (!repository.existsById(aula.getId())) {
			throw new ResourceNotFoundException("Aula não encontrada, Id inexistente.");
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
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Aula não encontrada, id inexistente."));
	}

	@Override
	public Aula update(Integer id, Aula aula) {
		if (!repository.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Aula não encontrada, id inexistente.");
		}
		aula.setId(id);
		return save(aula);
	}

}
