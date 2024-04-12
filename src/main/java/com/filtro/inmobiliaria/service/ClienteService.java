package com.filtro.inmobiliaria.service;


import java.util.List;

import com.filtro.inmobiliaria.repository.entitiesDTO.ClienteDTO;




public interface ClienteService {


    public ClienteDTO save(ClienteDTO ClienteDTO);

    public ClienteDTO update(Long id, ClienteDTO ClienteDTO);

    void deleteById(Long id);

    List<ClienteDTO> findAll();
}
