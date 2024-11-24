package com.proyecto.proyecto_web_springboot.service;

import com.proyecto.proyecto_web_springboot.entity.Curso;
import com.proyecto.proyecto_web_springboot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso saveCurso(Curso curso) {
        if (!curso.isValid()) {
            throw new IllegalArgumentException("Datos del curso inválidos");
        }
        return cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso updateCurso(Long id, Curso curso) {
        if (!cursoRepository.existsById(id)) {
            throw new IllegalArgumentException("Curso no encontrado");
        }

        if (!curso.isValid()) {
            throw new IllegalArgumentException("Datos del curso inválidos");
        }

        curso.setId(id);
        return cursoRepository.save(curso);
    }

    public boolean deleteCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
