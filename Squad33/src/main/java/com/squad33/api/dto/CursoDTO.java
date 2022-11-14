package com.squad33.api.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.squad33.api.models.Aula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
	
	private int id;
	@NotEmpty(message = "Campo nome não pode ser vazio")
	private String nome;
	@NotEmpty(message = "Campo nome não pode ser vazio")
	private String descricao;
	@NotNull(message = "Campo nome não pode ser nulo")
	private Integer trilha_id;
	private List<Aula> aulas;
}
