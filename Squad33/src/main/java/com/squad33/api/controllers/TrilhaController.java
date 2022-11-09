package com.squad33.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad33.api.models.Trilha;
import com.squad33.api.sevice.impl.TrilhaServiceImpl;

@RestController
@RequestMapping("/api/trilhas")
@CrossOrigin(origins = "*")
public class TrilhaController {

	@Autowired
	private TrilhaServiceImpl trilhaService;

	@GetMapping
	public Page<Trilha> getAll(@PageableDefault(size = 3) Pageable pageable) {
		return trilhaService.getAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Trilha findById(@PathVariable Integer id, Trilha trilha) {
		return trilhaService.findById(id);
	}

}
