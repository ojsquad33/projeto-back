package com.squad33.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.squad33.api.models.Aula;
import com.squad33.api.models.Curso;
import com.squad33.api.models.Trilha;
import com.squad33.api.service.impl.AulaServiceImpl;
import com.squad33.api.service.impl.CursoServiceImpl;
import com.squad33.api.service.impl.TrilhaServiceImpl;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
	
	@Autowired
	private CursoServiceImpl cursoService;
	@Autowired
	private TrilhaServiceImpl trilhaService;
	@Autowired
	private AulaServiceImpl aulaService;
	
	@PostMapping("/cursos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Curso addCurso(@RequestBody @Valid Curso curso, @PathVariable Integer id) {
		curso.setTrilha(trilhaService.findById(id));
		return cursoService.save(curso);
	}
	
	@DeleteMapping("cursos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCursoById(@PathVariable Integer id) {
		cursoService.deleteById(id);
	}
	
	@PutMapping("cursos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Curso updateCursoById(@PathVariable Integer id, @RequestBody Curso curso) {
		return cursoService.update(id, curso);
	}
	
	
	@DeleteMapping("trilhas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTrilhaById(@PathVariable Integer id) {
		trilhaService.deleteById(id);
	}
	
	@PutMapping("trilhas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Trilha updateTrilhaById(@PathVariable Integer id, @RequestBody Trilha trilha) {
		return trilhaService.update(id,trilha);
	}
	
	@PostMapping("trilhas")
	@ResponseStatus(HttpStatus.CREATED)
	public Trilha addTrilha(@RequestBody @Valid Trilha trilha) {
		
		return trilhaService.save(trilha);
	}
	
	@PostMapping("/aulas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Aula addAula(@RequestBody @Valid Aula aula, @PathVariable Integer id) {
		Curso curso = cursoService.findById(id);
		aulaService.save(aula);
		curso.insertAula(aula);
		cursoService.save(curso);
		return aula;
	}
	@DeleteMapping("aulas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAulaById(@PathVariable Integer id) {
		aulaService.deleteById(id);
	}
	
	@PutMapping("aulas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Aula updateAulaById(@PathVariable Integer id, @RequestBody Aula aula) {
		return aulaService.update(id,aula);
	}
	
}
