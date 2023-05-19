package com.softtek.cursos.excepciones;

public class ModeloExcepcionNoEncontrado extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ModeloExcepcionNoEncontrado(String message) {
        super(message);
    }
}
