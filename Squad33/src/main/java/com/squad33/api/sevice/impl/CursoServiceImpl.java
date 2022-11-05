package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import com.squad33.api.sevice.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.models.Curso;
import com.squad33.api.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements ICursoService {
	
	@Autowired
	private CursoRepository repository;

	public Curso save(Curso curso) {
		return repository.save(curso);
	}
	
	public Curso update(Integer id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Curso curso = repository.findById(id).orElse(null);
		return save(curso);
	}

	public void deleteById(Integer id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		repository.deleteById(id);
	}
	
	public void deleteCurso(Curso curso) {
		repository.delete(curso);
	}

	public List<Curso> getAll() {
		return repository.findAll();
	}

	@Override
	public Curso findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Optional<Curso> FindById(Integer id) {
		return repository.findById(id);
	}

}
