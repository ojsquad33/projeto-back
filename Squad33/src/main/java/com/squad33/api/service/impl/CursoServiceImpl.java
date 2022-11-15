package com.squad33.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad33.api.error.ResourceNotFoundException;
import com.squad33.api.models.Curso;
import com.squad33.api.repositories.CursoRepository;
import com.squad33.api.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private CursoRepository repository;

    @Override
    public Curso save(Curso curso) {
        return repository.save(curso);
    }
    @Override
    public Curso update(Integer id, Curso curso) {
        if (!repository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Curso não encontrado, id inexistente.");
        }
        curso.setId(id);
        return save(curso);
    }
    @Override
    public void deleteById(Integer id) {
        if (!repository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Curso não encontrado, id inexistente.");
        }
        repository.deleteById(id);
    }
    @Override
    public void deleteCurso(Curso curso) {
        if (!repository.existsById(curso.getId())) {
            throw new ResourceNotFoundException("Curso não encontrado, id inexistente.");
        }
        repository.delete(curso);
    }
    @Override
    public List<Curso> getAll() {
        return repository.findAll();
    }

    @Override
    public Curso findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
    }

}
