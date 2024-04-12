package com.filtro.inmobiliaria.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.filtro.inmobiliaria.repository.entities.Cliente;
import com.filtro.inmobiliaria.repository.entitiesDTO.ClienteDTO;


@Configuration
public class ClienteConversion {
    

    @Autowired
    private ModelMapper dbm;

    public Cliente convertirDTOACliente(ClienteDTO ClienteDTO){
        return dbm.map(ClienteDTO,Cliente.class);
    }

    public ClienteDTO convertirClienteADto(Cliente Cliente){
        ClienteDTO ClienteDTO = dbm.map(Cliente, ClienteDTO.class);

        ClienteDTO.setId_cliente(Cliente.getId_cliente());
        ClienteDTO.setNombre(Cliente.getNombre());
        ClienteDTO.setApellido(Cliente.getApellido());
        ClienteDTO.setTelefono(Cliente.getTelefono());
        ClienteDTO.setCorreo(Cliente.getCorreo());

        return ClienteDTO;
    }
}

