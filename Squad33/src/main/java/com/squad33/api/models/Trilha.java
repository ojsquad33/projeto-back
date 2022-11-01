package com.squad33.api.models;

import java.util.List;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Trilha {
	private String nomeDaTrilha;
	private List<Curso> cursos; 

}
