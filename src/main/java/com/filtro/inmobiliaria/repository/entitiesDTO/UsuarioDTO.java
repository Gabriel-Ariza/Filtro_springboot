package com.filtro.inmobiliaria.repository.entitiesDTO;


import java.util.List;

import com.filtro.inmobiliaria.repository.entities.Role;
import jakarta.validation.constraints.NotEmpty;
//import com.filtro.inmobiliaria.repository.entities.Cliente;
import lombok.Data;



@Data
public class UsuarioDTO {
    

    private Long id;
    @NotEmpty(message = "no puede estar vacio")
    private String email;
    @NotEmpty(message = "no puede estar vacio")
    private String password;
    @NotEmpty(message = "no puede estar vacio")
    private List<Role> roles;
}
