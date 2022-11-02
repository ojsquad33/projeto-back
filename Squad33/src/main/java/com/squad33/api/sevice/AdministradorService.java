package com.squad33.api.sevice;

import java.util.List;
import java.util.Optional;

import com.squad33.api.models.Aula;
import com.squad33.api.models.Curso;

public interface AdministradorService {

	public void deleteAula(Aula aula);

	public void deleteCurso(Curso curso);

	public List<Aula> getAllAulas();

	public List<Curso> getAllCursos();

	public Optional<Curso> FindCursoById(Integer id);

	public Optional<Aula> FindAulaById(Integer id);

	public Aula addAula(Aula aula);

	public Curso addCurso(Curso curso);
}
