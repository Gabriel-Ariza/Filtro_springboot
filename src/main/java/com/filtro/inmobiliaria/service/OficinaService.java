package com.filtro.inmobiliaria.service;


import java.util.List;
import com.filtro.inmobiliaria.repository.entitiesDTO.OficinaDTO;



public interface OficinaService {
    
    public OficinaDTO save(OficinaDTO OficinaDTO);

    public OficinaDTO update(Long id, OficinaDTO OficinaDTO);

    void deleteById(Long id);

    List<OficinaDTO> findAll();

}

