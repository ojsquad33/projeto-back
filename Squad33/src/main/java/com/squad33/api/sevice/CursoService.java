package com.squad33.api.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Curso;
import com.squad33.api.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;

	public Curso save(Curso curso) {
		return repository.save(curso);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void deleteCurso(Curso curso) {
		repository.delete(curso);
	}

	public List<Curso> getAll() {
		return repository.findAll();
	}

	public Optional<Curso> FindById(Integer id) {
		return repository.findById(id);
	}

}
