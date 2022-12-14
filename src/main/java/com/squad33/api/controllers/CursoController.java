package com.squad33.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.squad33.api.dto.CursoDTO;
import com.squad33.api.models.Curso;
import com.squad33.api.service.impl.CursoServiceImpl;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	@Autowired
	private CursoServiceImpl cursoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CursoDTO> getAll(){
		
		return cursoService.getAll().stream().map(curso -> cursoDTO(curso)).toList();
	}
	
	private CursoDTO cursoDTO(Curso curso) {
		CursoDTO cursoDTO = new CursoDTO();
		cursoDTO.setId(curso.getId());
		cursoDTO.setTrilha_id(curso.getTrilha().getId());
		cursoDTO.setNome(curso.getNome());
		cursoDTO.setDescricao(curso.getDescricao());
		cursoDTO.setAulas(curso.getAulas());
		return cursoDTO;
	}
	
}
