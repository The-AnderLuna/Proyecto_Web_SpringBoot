package com.proyecto.proyecto_web_springboot.repository;

import com.proyecto.proyecto_web_springboot.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

}
