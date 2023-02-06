package com.example.backendses04.model.builders;

import org.hibernate.mapping.Map;

import java.time.LocalDateTime;

public class RespuestaError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int estatus;
    private Map errores;
    private String ruta;
}
