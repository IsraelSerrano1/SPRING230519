package com.softtek.cursos.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class ErroresInterceptor extends ResponseEntityExceptionHandler {
    public final ResponseEntity<ExcepcionRespuesta> manejadorTodasLasExcepciones(Exception ex, WebRequest request) {
        ExcepcionRespuesta excepcion = new ExcepcionRespuesta(ex.getMessage(), LocalDateTime.now(),request.getDescription(false));
        return new ResponseEntity<>(excepcion, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModeloExcepcionNoEncontrado.class)
    public ResponseEntity<ExcepcionRespuesta> manejadorExcepcionNoEncontradoModelo(ModeloExcepcionNoEncontrado ex, WebRequest request) {
        ExcepcionRespuesta excepcion = new ExcepcionRespuesta(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity<>(excepcion, HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensaje = ex.getBindingResult().getAllErrors().stream().map(e -> {return e.getDefaultMessage().concat(",");}).collect(Collectors.joining(", "));
        ExcepcionRespuesta excepcion = new ExcepcionRespuesta(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity<>(excepcion, HttpStatus.BAD_REQUEST);
    }
}
