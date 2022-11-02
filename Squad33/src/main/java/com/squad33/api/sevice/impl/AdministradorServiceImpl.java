package com.squad33.api.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.models.Aula;
import com.squad33.api.models.Curso;
import com.squad33.api.sevice.AdministradorService;
import com.squad33.api.sevice.AulaService;
import com.squad33.api.sevice.CursoService;

@Service
public class AdministradorServiceImpl implements AdministradorService{
	
	@Autowired
	private AulaService aulaService;
	@Autowired
	private CursoService cursoService;

	@Override
	public void deleteAula(Aula aula) {
		aulaService.deleteAula(aula);
	}

	@Override
	public void deleteCurso(Curso curso) {
		cursoService.deleteCurso(curso);
	}

	@Override
	public List<Aula> getAllAulas() {
		return aulaService.getAll();
	}

	@Override
	public List<Curso> getAllCursos() {
		return cursoService.getAll();
	}

	@Override
	public Optional<Curso> FindCursoById(Integer id) {
		return cursoService.FindById(id);
	}

	@Override
	public Optional<Aula> FindAulaById(Integer id) {
		// TODO Auto-generated method stub
		return aulaService.FindById(id);
	}

	@Override
	public Aula addAula(Aula aula) {
		return aulaService.save(aula);
	}

	@Override
	public Curso addCurso(Curso curso) {
		return cursoService.save(curso);
	}

}
