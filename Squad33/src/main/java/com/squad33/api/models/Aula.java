package com.squad33.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30,nullable = false,unique = true)
	private String titulo;
	@Column(length = 700,nullable = false,unique = true)
	private String descricao;
	@Column(length = 50,nullable = false)
	private String professor;
	@Column(nullable = false, unique = true)
	private String url;
	@JoinColumn(name = "curso_id")
	@ManyToOne
	private Curso curso;
}
