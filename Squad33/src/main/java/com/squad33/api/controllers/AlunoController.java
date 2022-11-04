package com.squad33.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.squad33.api.models.Aluno;
import com.squad33.api.sevice.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl alunoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Aluno> getAll() {
		return  alunoService.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	// Ver 04.11.2022 - > @ExceptionHandler
	public Aluno findById(@PathVariable Integer id) {
		return  alunoService.FindById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Object> save(@RequestBody @Valid Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
	}


@PutMapping
	public Object update(@RequestBody Aluno aluno) {
	return save(aluno);
		
	}
}
