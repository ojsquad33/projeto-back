package com.squad33.api.sevice;


import com.squad33.api.models.Aula;

import java.util.List;

public interface IAulaService {

    public List<Aula> getAll();

    public Aula findById(Integer id);
    
    public Aula update(Integer id);



}
