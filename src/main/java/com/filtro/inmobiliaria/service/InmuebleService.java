package com.filtro.inmobiliaria.service;


import java.util.List;
import java.util.Optional;

import com.filtro.inmobiliaria.repository.entitiesDTO.InmuebleDTO;



public interface InmuebleService {
    
    public InmuebleDTO save(InmuebleDTO InmuebleDTO);

    public InmuebleDTO update(Long id, InmuebleDTO InmuebleDTO);

    void deleteById(Long id);

    List<InmuebleDTO> findAll();

    InmuebleDTO findById(Long id);

    List<InmuebleDTO> ListadoEstancias();

    List<InmuebleDTO> findAvailableForSaleOrRent(String type);

    InmuebleDTO findByCodigo(Long codigo);
}
