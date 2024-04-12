package com.filtro.inmobiliaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.filtro.inmobiliaria.repository.entities.Oficina;


public interface OficinaRepository extends JpaRepository<Oficina,Long> {
    
}
