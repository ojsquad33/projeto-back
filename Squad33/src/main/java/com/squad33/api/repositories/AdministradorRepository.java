package com.squad33.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad33.api.models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	
}
