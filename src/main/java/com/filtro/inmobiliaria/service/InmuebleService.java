package com.filtro.inmobiliaria.service;


import java.util.List;
import com.filtro.inmobiliaria.repository.entitiesDTO.InmuebleDTO;



public interface InmuebleService {
    
    public InmuebleDTO save(InmuebleDTO InmuebleDTO);

    public InmuebleDTO update(Long id, InmuebleDTO InmuebleDTO);

    void deleteById(Long id);

    List<InmuebleDTO> findAll();

    List<InmuebleDTO> ListadoEstancias();
}
