package com.squad33.api.models;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Administrador {
	private String nome, email, senha;

}
