package com.filtro.inmobiliaria.service;


import java.util.List;

import com.filtro.inmobiliaria.repository.entitiesDTO.UsuarioDTO;





public interface UsuarioService {
    
    public UsuarioDTO save(UsuarioDTO usuario);

    public UsuarioDTO update(Long id, UsuarioDTO usuario);

    void deleteById(Long id);

    List<UsuarioDTO> findAll();
}
