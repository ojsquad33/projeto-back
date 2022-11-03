package com.squad33.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Trilha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "url_imagem", nullable = false)
	private String urlImagem;
	@Column(name = "nome_trilha")
	private String nomeDaTrilha;
	@OneToMany(mappedBy = "trilha")
	private List<Curso> cursos;
	

}
