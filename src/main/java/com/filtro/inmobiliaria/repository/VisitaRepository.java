package com.filtro.inmobiliaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.filtro.inmobiliaria.repository.entities.Visita;


public interface VisitaRepository extends JpaRepository<Visita, Long> {
    
}
