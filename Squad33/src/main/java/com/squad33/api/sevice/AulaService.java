package com.squad33.api.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Aula;
import com.squad33.api.repositories.AulaRepository;

@Service
public class AulaService {

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

	public Optional<Aula> FindById(Integer id) {
		return repository.findById(id);
	}

}
