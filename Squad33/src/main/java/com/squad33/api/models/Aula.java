package com.squad33.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
	@Column(length = 50,nullable = false,unique = true)
	@NotEmpty(message = "Campo titulo não pode ser vazio")
	private String titulo;
	@Column(length = 700,nullable = false,unique = true)
	@NotEmpty(message = "Campo descrição não pode ser vazio")
	private String descricao;
	@Column(length = 50,nullable = false)
	@NotEmpty(message = "Campo professor não pode ser vazio")
	private String professor;
	@Column(nullable = false, unique = true)
	@NotEmpty(message = "Campo url não pode ser vazio")
	private String url;
	@Column(nullable = false, length = 30)
	@NotEmpty(message = "Campo tipo não pode ser vazio")
	private String tipo;
	@Column
	private boolean concluido;
}
