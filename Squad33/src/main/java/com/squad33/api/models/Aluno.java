package com.squad33.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 110, nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@OneToMany
	@JoinColumn
	private List<Curso> cursos;
	


}
