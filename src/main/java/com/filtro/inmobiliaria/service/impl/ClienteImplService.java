package com.filtro.inmobiliaria.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.inmobiliaria.configuration.ClienteConversion;
import com.filtro.inmobiliaria.repository.ClienteRepository;
import com.filtro.inmobiliaria.repository.entities.Cliente;
import com.filtro.inmobiliaria.repository.entitiesDTO.ClienteDTO;
import com.filtro.inmobiliaria.service.ClienteService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClienteImplService implements ClienteService {
    

@Autowired
private ClienteRepository ClienteRepository;
private ClienteConversion ClienteConversion;


@Override
@Transactional
public ClienteDTO save(ClienteDTO ClienteDTO) {
    Cliente Cliente = ClienteConversion.convertirDTOACliente(ClienteDTO);
    ClienteRepository.save(Cliente);
    return ClienteConversion.convertirClienteADto(Cliente);
}


public ClienteDTO update(Long id, ClienteDTO ClienteDTO){
    Optional<Cliente> ClienteCurrentOptional = ClienteRepository.findById(id);
    if(ClienteCurrentOptional.isPresent()){
        Cliente ClienteCurrent = ClienteConversion.convertirDTOACliente(ClienteDTO);

        ClienteDTO.setId_cliente(ClienteDTO.getId_cliente());
        ClienteDTO.setNombre(ClienteDTO.getNombre());
        ClienteDTO.setApellido(ClienteDTO.getApellido());
        ClienteDTO.setTelefono(ClienteDTO.getTelefono());
        ClienteDTO.setCorreo(ClienteDTO.getCorreo());

        ClienteRepository.save(ClienteCurrent);
        return ClienteConversion.convertirClienteADto(ClienteCurrent);
    }
    return null;
}


@Override
public void deleteById(Long id){
    ClienteRepository.deleteById(id);
}


@Override
@Transactional(readOnly = true)
public List<ClienteDTO> findAll(){
    List<Cliente> Clientes = (List<Cliente>) ClienteRepository.findAll();
    return Clientes.stream()
                   .map(personita -> ClienteConversion.convertirClienteADto(personita))
                   .toList();
}

}
