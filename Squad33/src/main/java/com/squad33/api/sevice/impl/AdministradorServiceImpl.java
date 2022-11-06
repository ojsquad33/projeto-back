package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import com.squad33.api.models.Trilha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Aula;
import com.squad33.api.models.Curso;
import com.squad33.api.sevice.IAdministradorService;
import org.springframework.web.server.ResponseStatusException;

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
	trilhaServiceImpl.deleteById(Trilha.getId());
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
	public Curso findCursoById(Integer id) {
		return cursoServiceImpl.findById(id);
	}

	@Override
	public Trilha findTrilhaById(Integer id) {
		return trilhaServiceImpl.findById(id);
	}

	@Override
	public Aula findAulaById(Integer id) {
		return aulaServiceImpl.findById(id);
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
