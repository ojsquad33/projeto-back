package com.squad33.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad33.api.models.Trilha;
import com.squad33.api.sevice.impl.TrilhaServiceImpl;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {
	
	@Autowired
	private TrilhaServiceImpl trilhaService;
	
	@GetMapping
	public List<Trilha> getAll(){
		return trilhaService.getAll(); 
	}

}
