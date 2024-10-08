package com.sesi.sistemaPedidos.repository;

import com.sesi.sistemaPedidos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
