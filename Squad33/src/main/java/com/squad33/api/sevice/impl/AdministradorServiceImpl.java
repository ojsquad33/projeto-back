package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import com.squad33.api.models.Trilha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Aula;
import com.squad33.api.models.Curso;
import com.squad33.api.sevice.IAdministradorService;

@Service
public class AdministradorServiceImpl implements IAdministradorService {
	
	@Autowired
	private AulaServiceImpl aulaServiceImpl;
	@Autowired
	private CursoServiceImpl cursoServiceImpl;

	@Autowired
	private TrilhaServiceImpl trilhaServiceImpl;

	@Override
	public void deleteAula(Aula aula) {
		aulaServiceImpl.deleteAula(aula);
	}

	@Override
	public void deleteCurso(Curso curso) {
		cursoServiceImpl.deleteCurso(curso);
	}

	@Override
	public void deleteTrilha(Trilha Trilha) {

	}

	@Override
	public List<Aula> getAllAulas() {
		return aulaServiceImpl.getAll();
	}

	@Override
	public List<Curso> getAllCursos() {
		return cursoServiceImpl.getAll();
	}

	@Override
	public List<Trilha> getAllTrilhas() {
		return null;
	}

	@Override
	public Optional<Curso> FindCursoById(Integer id) {
		return cursoServiceImpl.FindById(id);
	}

	@Override
	public Optional<Trilha> FindTrilhaById(Integer id) {
		return Optional.empty();
	}

	@Override
	public Optional<Aula> FindAulaById(Integer id) {
		return aulaServiceImpl.FindById(id);
	}

	@Override
	public Aula addAula(Aula aula) {
		return aulaServiceImpl.save(aula);
	}

	@Override
	public Curso addCurso(Curso curso) {
		return cursoServiceImpl.save(curso);
	}

	@Override
	public Trilha addTrilha(Trilha trilha) {
		return trilhaServiceImpl.save(trilha);
	}

}
