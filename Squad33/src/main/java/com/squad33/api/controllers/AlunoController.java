package com.squad33.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
	public Aluno findById(@PathVariable Integer id) {
		return  alunoService.FindById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Object> save(@RequestBody @Valid Aluno aluno) {
		if(alunoService.existsByEmail(aluno.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este email já está sendo utilizado");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		alunoService.FindById(id).map(aluno -> {
			alunoService.deleteById(id);
			return aluno;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado"));
	}
	
	
	@PutMapping
	public Object update(@RequestBody Aluno aluno) {
		return save(aluno);
		
	}
}
