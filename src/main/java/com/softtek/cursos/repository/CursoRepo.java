package com.softtek.cursos.repository;

import com.softtek.cursos.modelo.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CursoRepo implements ICursoRepo{

    public List<Curso> cursoList = new ArrayList<>();
    @Override
    public List<Curso> findAll() {
        return cursoList;
    }

    @Override
    public Curso findOne(int id) {
        return cursoList.stream() .filter(c -> c.getIdCurso() == id) .findFirst() .orElse(null);
    }

    @Override
    public Curso create(Curso curso) {
        cursoList.add(curso);
        return curso;
    }

    @Override
    public Curso update(Curso curso) {
        Curso cursoAux = null;
        for (Curso c : this.cursoList){
            if (c.getIdCurso() == curso.getIdCurso()){
                cursoAux = c;

            }
        }
        this.cursoList.set(this.cursoList.indexOf(cursoAux),curso);
        return curso;
    }

    @Override
    public void delete(int id){ cursoList.removeIf(c -> c.getIdCurso() == id);}
}

