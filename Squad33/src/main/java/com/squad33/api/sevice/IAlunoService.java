package com.squad33.api.sevice;

import java.util.List;
import java.util.Optional;

import com.squad33.api.models.Aluno;

public interface IAlunoService {
	
	
	public Aluno save(Aluno aluno);

	public List<Aluno> getAll();

	public Aluno FindById(Integer id);
	
	public boolean existsByEmail(String email);


	
}
