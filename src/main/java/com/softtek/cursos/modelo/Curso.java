package com.softtek.cursos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
    private int idCurso;
    private String nombre;
    private int duracion;
    private int idProfesor;
}
