package com.squad33.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad33.api.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
}
