package com.squad33.api.models;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Aula {
	private String titulo;
	private String descricao;
	private String professor;
	private String url;

}
