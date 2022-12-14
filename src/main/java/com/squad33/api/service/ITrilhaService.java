package com.squad33.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.squad33.api.models.Trilha;

public interface ITrilhaService {

    public Page<Trilha> getAll(Pageable pageable);
    

    public List<Trilha> getAll();

    public Trilha findById(Integer id);
    
    public void deleteById(Integer id);

    public Trilha save(Trilha trilha);

    public Trilha update(Integer id, Trilha trilha);

}
