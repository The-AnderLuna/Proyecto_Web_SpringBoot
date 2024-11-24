package com.proyecto.proyecto_web_springboot.controller;

import com.proyecto.proyecto_web_springboot.entity.Curso;
import com.proyecto.proyecto_web_springboot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String getAllCursos(Model model) {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "curso/listar_cursos";
    }

    @GetMapping("/create")
    public String showCreateCursoForm(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/crear_curso";
    }

    @PostMapping("/create")
    public String createCurso(@ModelAttribute Curso curso, Model model) {
        try {
            Curso nuevoCurso = cursoService.saveCurso(curso);
            model.addAttribute("message", "Curso creado con éxito");
            return "redirect:/cursos";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Error al crear el curso");
            return "curso/crear_curso";
        }
    }

    @GetMapping("/edit")
    public String showEditCursoForm(@RequestParam Long id, Model model) {
        Optional<Curso> cursoOpt = cursoService.findById(id);
        if (cursoOpt.isPresent()) {
            model.addAttribute("curso", cursoOpt.get());
            return "curso/editar_curso";
        } else {
            model.addAttribute("error", "Curso no encontrado");
            return "error";
        }
    }

    @PostMapping("/edit")
    public String updateCurso(@ModelAttribute Curso curso, Model model) {
        try {
            Curso updatedCurso = cursoService.updateCurso(curso.getId(), curso);
            model.addAttribute("message", "Curso actualizado con éxito");
            return "redirect:/cursos";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Error al actualizar el curso");
            return "curso/editar_curso";
        }
    }

    @PostMapping("/delete")
    public String deleteCurso(@RequestParam Long id, Model model) {
        boolean isDeleted = cursoService.deleteCurso(id);
        if (isDeleted) {
            model.addAttribute("message", "Curso eliminado con éxito");
        } else {
            model.addAttribute("error", "Error al eliminar el curso");
        }
        return "redirect:/cursos";
    }
}
