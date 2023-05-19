package com.softtek.cursos.excepciones;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExcepcionRespuesta {
    @JsonProperty
    private String message;
    @JsonProperty
    private LocalDateTime date;
    @JsonProperty
    private String detail;
}
