package com.squad33.api.models;

import java.util.List;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Curso {
	private String nome;
	private String descricao;
	private double tempoDuracao; // int, double, String???
	private List<Aula> aulas;

}
