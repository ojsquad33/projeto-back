package com.squad33.api.sevice;

import com.squad33.api.models.Curso;


import java.util.List;

public interface ICursoService {

    public List<Curso> getAll();

    public Curso findById(Integer id);



}
