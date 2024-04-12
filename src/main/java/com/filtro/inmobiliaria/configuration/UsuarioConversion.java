package com.filtro.inmobiliaria.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.filtro.inmobiliaria.repository.entities.Usuario;
import com.filtro.inmobiliaria.repository.entitiesDTO.UsuarioDTO;


@Configuration
public class UsuarioConversion {
    

    @Autowired
    private ModelMapper dbm;

    public Usuario convertirDTOAUsuario(UsuarioDTO UsuarioDTO){
        return dbm.map(UsuarioDTO,Usuario.class);
    }

    public UsuarioDTO convertirUsuarioADTO(Usuario Usuario){
        UsuarioDTO UsuarioDTO = dbm.map(Usuario, UsuarioDTO.class);

        UsuarioDTO.setId(Usuario.getId());
        UsuarioDTO.setEmail(Usuario.getEmail());
        UsuarioDTO.setPassword(Usuario.getPassword());
        UsuarioDTO.setRoles(Usuario.getRoles());

        return UsuarioDTO;
    }
}
