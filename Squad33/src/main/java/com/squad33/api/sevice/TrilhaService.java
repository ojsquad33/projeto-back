package com.squad33.api.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Trilha;
import com.squad33.api.repositories.TrilhaRepository;

@Service
public class TrilhaService {
	
	@Autowired
	private TrilhaRepository repository;

	public List<Trilha> getAll(){
		return repository.findAll();
	}
}
