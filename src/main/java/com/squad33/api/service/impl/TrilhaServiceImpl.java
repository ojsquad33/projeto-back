package com.squad33.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.squad33.api.error.ResourceNotFoundException;
import com.squad33.api.models.Trilha;
import com.squad33.api.repositories.TrilhaRepository;
import com.squad33.api.service.ITrilhaService;

@Service
public class TrilhaServiceImpl implements ITrilhaService {
	
	@Autowired
	private TrilhaRepository repository;

	@Override
	public Page<Trilha> getAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	@Override
	public List<Trilha> getAll(){
		return repository.findAll();
	}

	@Override
	public Trilha findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada, id inexistente."));
	}

	@Override
	public Trilha save(Trilha trilha) {
		return repository.save(trilha);
	}

	@Override
	public void deleteById(Integer id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Trilha não encontrada, id inexistente.");
		}
		repository.deleteById(id);
	}

	@Override
	public Trilha update(Integer id,Trilha trilha) {

		if(!repository.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Trilha não encontrada, id inexistente.");
		}
		trilha.setId(id);
		return save(trilha);
	}
}
