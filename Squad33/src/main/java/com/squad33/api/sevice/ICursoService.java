package com.squad33.api.sevice;

import com.squad33.api.models.Curso;


import java.util.List;

public interface ICursoService {

    public Curso save(Curso curso);

    public Curso update(Integer id);

    public void deleteById(Integer id);

    public void deleteCurso(Curso curso);

    public List<Curso> getAll();

    public Curso findById(Integer id);





}
