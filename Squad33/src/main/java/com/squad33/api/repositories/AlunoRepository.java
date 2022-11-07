package com.squad33.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad33.api.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	boolean existsByEmail(String email);
	
	Optional<Aluno> findByEmail(String email);

}
