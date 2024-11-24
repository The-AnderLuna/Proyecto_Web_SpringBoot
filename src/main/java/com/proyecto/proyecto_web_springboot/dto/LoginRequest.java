package com.proyecto.proyecto_web_springboot.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
