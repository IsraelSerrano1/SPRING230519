package com.softtek.cursos.repository;

import com.softtek.cursos.modelo.Curso;

import java.util.List;

public interface ICursoRepo {

    List<Curso> findAll();
    Curso findOne(int id);
    Curso create(Curso curso);
    Curso update(Curso curso);
    void delete(int id);

}
