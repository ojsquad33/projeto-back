package com.squad33.api.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trilha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "url_imagem", nullable = false)
	@NotEmpty(message = "Campo url não pode ser vazio")
	private String urlImagem;
	@Column(name = "nome_trilha")
	@NotEmpty(message = "Campo nome da trilha não pode ser vazio")
	private String nomeDaTrilha;
	@Column
	@NotEmpty(message = "Campo descrição não pode ser vazio")
	private String descricao;
	@OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL)
	private List<Curso> cursos;
	

}
