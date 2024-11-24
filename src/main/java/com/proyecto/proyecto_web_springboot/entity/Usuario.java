package com.proyecto.proyecto_web_springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, length = 50)
    private String rol;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 15, unique = true)
    private String telefono;

    @Column(length = 50)
    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;

    public boolean isValid() {
        return validatePassword(password) && validateNombre(nombre) && validateApellidos(apellidos) && validateEmail(email) && validateFechaRegistro(fechaRegistro);
    }

    private boolean validatePassword(String password) {
        return password != null && password.length() >= 8;
    }

    private boolean validateNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    private boolean validateApellidos(String apellidos) {
        return apellidos != null && !apellidos.trim().isEmpty();
    }

    private boolean validateEmail(String email) {
        return email != null && email.contains("@");
    }

    private boolean validateFechaRegistro(Date fechaRegistro) {
        return fechaRegistro != null;
    }
}



