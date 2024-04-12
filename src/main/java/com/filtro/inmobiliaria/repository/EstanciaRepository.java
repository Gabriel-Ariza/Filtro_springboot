package com.filtro.inmobiliaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.filtro.inmobiliaria.repository.entities.Estancia;


public interface EstanciaRepository extends JpaRepository<Estancia,Long> {
    
}
