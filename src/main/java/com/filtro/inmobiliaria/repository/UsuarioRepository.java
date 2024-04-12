package com.filtro.inmobiliaria.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.inmobiliaria.repository.entities.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}
