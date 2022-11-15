package com.squad33.api.service;


import com.squad33.api.models.Aula;

import java.util.List;

public interface IAulaService {

    public Aula save(Aula aula);

    public void deleteById(Integer id);

    public void deleteAula(Aula aula);

    public List<Aula> getAll();

    public Aula findById(Integer id);
    
    public Aula update(Integer id, Aula aula);



}
