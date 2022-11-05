package com.squad33.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.squad33.api.models.Curso;
import com.squad33.api.sevice.impl.CursoServiceImpl;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	@Autowired
	private CursoServiceImpl cursoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Curso> getAll(){
		return cursoService.getAll();
	}
}
