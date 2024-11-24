package com.proyecto.proyecto_web_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "auth/register";
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
        return "auth/forgot-password";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "auth/home";
    }

    @GetMapping("/usuarios")
    public String showUsuariosPage() {
        return "usuario/usuario";
    }

    @GetMapping("/usuarios/create")
    public String showCreateUserPage() {
        return "usuario/crear_usuario";
    }

    @GetMapping("/usuarios/search")
    public String showSearchUserPage() {
        return "usuario/buscar_usuario";
    }

    @GetMapping("/usuarios/edit")
    public String showEditUserPage() {
        return "usuario/editar_usuario";
    }

    @GetMapping("/usuarios/list")
    public String showListUsersPage() {
        return "usuario/listar_usuarios";
    }

    @GetMapping("/cursos")
    public String showCursosPage() {
        return "curso/curso";
    }

    @GetMapping("/cursos/create")
    public String showCreateCursoPage() {
        return "curso/crear_curso";
    }

    @GetMapping("/cursos/search")
    public String showSearchCursoPage() {
        return "curso/buscar_curso";
    }

    @GetMapping("/cursos/edit")
    public String showEditCursoPage() {
        return "curso/editar_curso";
    }

    @GetMapping("/cursos/delete")
    public String showDeleteCursoPage() {
        return "curso/eliminar_curso";
    }

    @GetMapping("/cursos/list")
    public String showListCursosPage() {
        return "curso/listar_curso";
    }
}
