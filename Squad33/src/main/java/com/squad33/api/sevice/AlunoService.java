package com.squad33.api.sevice;

import java.util.List;
import java.util.Optional;

import com.squad33.api.models.Aluno;

public interface AlunoService {
	
	
	public Aluno save(Aluno aluno);
	
	public void deleteById(Integer id);
	
	public List<Aluno> getAll();

	public Optional<Aluno> FindById(Integer id);
	
	public boolean existsByEmail(String email);
	
}
