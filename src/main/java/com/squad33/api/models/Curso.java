package com.squad33.api.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 50, unique = true)
	private String nome;
	@Column(nullable = false, length = 700)
	private String descricao;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Aula> aulas;
	@ManyToOne
	@JsonIgnore
	private Trilha trilha;
	
	public void insertAula(Aula aula) {
		aulas.add(aula);
	}

}
