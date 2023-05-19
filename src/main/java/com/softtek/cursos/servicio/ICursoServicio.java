package com.softtek.cursos.servicio;

import com.softtek.cursos.modelo.Curso;

import java.util.List;

public interface ICursoServicio {
    List<Curso> findAll();
    Curso findOne(int id);
    Curso create(Curso curso);
    Curso update(Curso curso);
    void delete(int id);

}
