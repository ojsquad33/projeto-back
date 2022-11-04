package com.squad33.api.sevice.impl;

import java.util.List;

import com.squad33.api.sevice.ITrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return repository.findById(id).orElse(null);
	}

	public Trilha addTrilha(Trilha trilha) {
		return repository.save(trilha);
	}
}
