package com.proyecto.proyecto_web_springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "Cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Float duracion;

    @Column(nullable = false)
    private Integer estudiantes;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public boolean isValid() {
        return validateNombre(nombre) && validateDuracion(duracion) && validateEstudiantes(estudiantes) && validateFechaInicio(fechaInicio);
    }

    private boolean validateNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    private boolean validateDuracion(Float duracion) {
        return duracion != null && duracion >= 1;
    }

    private boolean validateEstudiantes(Integer estudiantes) {
        return estudiantes != null && estudiantes >= 1;
    }

    private boolean validateFechaInicio(Date fechaInicio) {
        return fechaInicio != null;
    }
}
