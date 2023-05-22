package com.softtek.cursos.controlador;

import com.softtek.cursos.excepciones.ModeloExcepcionNoEncontrado;
import com.softtek.cursos.modelo.Curso;
import com.softtek.cursos.servicio.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/cursos")
public class CursosControlador {
    @Autowired
    private ICursoServicio servicio;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return new ResponseEntity<>(servicio.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Curso> findOne(@PathVariable("id") int id) {
        Curso cursoResultado = servicio.findOne(id);
        if(cursoResultado == null){
            throw new ModeloExcepcionNoEncontrado("Id no encontrado " + id);
        }
        return new ResponseEntity<>(servicio.findOne(id), HttpStatus.OK);
    }
@GetMapping("/hateos/{id}")
    public EntityModel<Curso> findOneH(@PathVariable("id") int id) throws Exception{
        Curso cursoResultado = servicio.findOne(id);
        if(cursoResultado == null){
            throw new ModeloExcepcionNoEncontrado("Id no encontrado " + id);
        }
        WebMvcLinkBuilder LinkOne = linkTo(methodOn(this.getClass()).findOne(id));
        return EntityModel.of(cursoResultado).add(LinkOne.withRel("curso-link"));
    }

//    @PostMapping
//    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
//        return new ResponseEntity<>(servicio.create(curso), HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Curso curso) throws Exception {
        Curso cursoAux = servicio.create(curso);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cursoAux.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Curso> update(@RequestBody Curso curso) {
        Curso cursoResultado = servicio.findOne(curso.getIdCurso());
        if(cursoResultado == null){
            throw new ModeloExcepcionNoEncontrado("Id no encontrado" + curso.getIdCurso());
        }
        return new ResponseEntity<>(servicio.update(curso), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id){
        Curso cursoResultado = servicio.findOne(id);
        if(cursoResultado == null){
            throw new ModeloExcepcionNoEncontrado("Id no encontrado");
        }
        servicio.delete(id);
    }
}


