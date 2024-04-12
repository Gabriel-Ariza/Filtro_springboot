package com.filtro.inmobiliaria.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.inmobiliaria.configuration.UsuarioConversion;
import com.filtro.inmobiliaria.repository.UsuarioRepository;
import com.filtro.inmobiliaria.repository.entities.Usuario;
import com.filtro.inmobiliaria.repository.entitiesDTO.UsuarioDTO;
import com.filtro.inmobiliaria.service.UsuarioService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UsuarioImplService implements UsuarioService  {
        
    @Autowired
    private UsuarioRepository usuarioRepository;
    private UsuarioConversion usuarioConversion;

    @Override
    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioConversion.convertirDTOAUsuario(usuarioDTO);
        usuarioRepository.save(usuario);
        return usuarioConversion.convertirUsuarioADTO(usuario);

    }

    @Override
    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO usuario){

        //busca el usuario por id en la bd
        Optional<Usuario> usuarioCurrentOptional = usuarioRepository.findById(id);

        //valida si el usuario esta
        if(usuarioCurrentOptional.isPresent()){

            //convierto EL DTO que traia de parametro a entidad
            Usuario usuarioCurrent = usuarioConversion.convertirDTOAUsuario(usuario);
            usuarioCurrent.setId(id);
            //usuarioCurrent.setCedula(usuario.getCedula());

            //Guardado en la BD
            usuarioRepository.save(usuarioCurrent);

            return usuarioConversion.convertirUsuarioADTO(usuarioCurrent);
        }
        return null;     
    }

    @Override 
    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll(){
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        return usuarios.stream()
                        .map(usuario -> usuarioConversion.convertirUsuarioADTO(usuario))
                        .toList();
    }

}
