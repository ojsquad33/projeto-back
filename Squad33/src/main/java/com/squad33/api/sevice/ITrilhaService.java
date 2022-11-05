package com.squad33.api.sevice;

import com.squad33.api.models.Trilha;

import java.util.List;

public interface ITrilhaService {

    public List<Trilha> getAll();

    public Trilha findById(Integer id);



}
