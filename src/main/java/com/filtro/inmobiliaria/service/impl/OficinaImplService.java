package com.filtro.inmobiliaria.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.inmobiliaria.configuration.OficinaConversion;
import com.filtro.inmobiliaria.repository.OficinaRepository;
import com.filtro.inmobiliaria.repository.entities.Oficina;
import com.filtro.inmobiliaria.repository.entitiesDTO.OficinaDTO;
import com.filtro.inmobiliaria.service.OficinaService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class OficinaImplService implements OficinaService {
    

@Autowired
private OficinaRepository OficinaRepository;
private OficinaConversion OficinaConversion;


@Override
@Transactional
public OficinaDTO save(OficinaDTO OficinaDTO) {
    Oficina Oficina = OficinaConversion.convertirDTOAOficina(OficinaDTO);
    OficinaRepository.save(Oficina);
    return OficinaConversion.convertirOficinaADto(Oficina);
}


public OficinaDTO update(Long id, OficinaDTO OficinaDTO){
    Optional<Oficina> OficinaCurrentOptional = OficinaRepository.findById(id);
    if(OficinaCurrentOptional.isPresent()){
        Oficina OficinaCurrent = OficinaConversion.convertirDTOAOficina(OficinaDTO);

        OficinaDTO.setId_oficina(OficinaDTO.getId_oficina());
        OficinaDTO.setDireccion(OficinaDTO.getDireccion());
        OficinaDTO.setUrbanizacion(OficinaDTO.getUrbanizacion());

        OficinaRepository.save(OficinaCurrent);
        return OficinaConversion.convertirOficinaADto(OficinaCurrent);
    }
    return null;
}


@Override
public void deleteById(Long id){
    OficinaRepository.deleteById(id);
}


@Override
@Transactional(readOnly = true)
public List<OficinaDTO> findAll(){
    List<Oficina> Oficinas = (List<Oficina>) OficinaRepository.findAll();
    return Oficinas.stream()
                   .map(personita -> OficinaConversion.convertirOficinaADto(personita))
                   .toList();
}

}
