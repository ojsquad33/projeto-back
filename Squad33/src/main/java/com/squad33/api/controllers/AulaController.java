package com.squad33.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.squad33.api.models.Aula;
import com.squad33.api.sevice.AulaService;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {
	
	@Autowired
	private AulaService aulaService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Aula> getAll(){
		return aulaService.getAll();
	}

}
