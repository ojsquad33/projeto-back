package com.squad33.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
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
	@Column(nullable = false, length = 30)
	private String tipo;
	@Column
	private boolean concluido;
}
