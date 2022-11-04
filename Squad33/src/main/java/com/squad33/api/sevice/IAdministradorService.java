package com.squad33.api.sevice;

import java.util.List;
import java.util.Optional;

import com.squad33.api.models.Aula;
import com.squad33.api.models.Curso;
import com.squad33.api.models.Trilha;

public interface IAdministradorService {

	public Aula addAula(Aula aula);

	public Curso addCurso(Curso curso);

	public Trilha addTrilha(Trilha trilha);


	public void deleteAula(Aula aula);

	public void deleteCurso(Curso curso);

	public void deleteTrilha(Trilha Trilha);

	public List<Aula> getAllAulas();

	public List<Curso> getAllCursos();

	public List<Trilha> getAllTrilhas();

	public Optional<Aula> FindAulaById(Integer id);

	public Optional<Curso> FindCursoById(Integer id);

	public Optional<Trilha> FindTrilhaById(Integer id);


}
