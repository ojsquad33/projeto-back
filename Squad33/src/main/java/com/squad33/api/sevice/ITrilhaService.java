package com.squad33.api.sevice;

import java.util.List;

import com.squad33.api.models.Curso;
import com.squad33.api.models.Trilha;

public interface ITrilhaService {

    public List<Trilha> getAll();

    public Trilha findById(Integer id);
    
    public void deleteById(Integer id);

    public Trilha save(Trilha trilha);
    
    public Curso saveCurso(Curso curso);
    
    public Trilha update(Integer id);


}
