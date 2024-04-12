package com.filtro.inmobiliaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.filtro.inmobiliaria.repository.entities.Cliente;


public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
    
}
