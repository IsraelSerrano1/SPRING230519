package com.softtek.cursos.servicio;

import com.softtek.cursos.modelo.Curso;
import com.softtek.cursos.repository.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicio implements ICursoServicio{
    @Autowired
    private ICursoRepo repo;

    @Override
    public List<Curso> findAll() {
        return repo.findAll();
    }

    @Override
    public Curso findOne(int id) {
        return repo.findOne(id);
    }

    @Override
    public Curso create(Curso curso) {
        return repo.create(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return repo.update(curso);
    }

    @Override
    public void delete(int id) { repo.delete(id);

    }
}
