package com.filtro.inmobiliaria.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.inmobiliaria.configuration.InmuebleConversion;
import com.filtro.inmobiliaria.repository.InmuebleRepository;
import com.filtro.inmobiliaria.repository.entities.Inmueble;
import com.filtro.inmobiliaria.repository.entitiesDTO.InmuebleDTO;
import com.filtro.inmobiliaria.service.InmuebleService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class InmuebleImplService implements InmuebleService {
        
    @Autowired
    private InmuebleRepository InmuebleRepository;
    private InmuebleConversion InmuebleConversion;

    @Override
    @Transactional
    public InmuebleDTO save(InmuebleDTO InmuebleDTO) {

        Inmueble Inmueble = InmuebleConversion.convertirDTOAInmueble(InmuebleDTO);
        InmuebleRepository.save(Inmueble);
        return InmuebleConversion.convertirInmuebleADTO(Inmueble);

    }

    @Override
    @Transactional
    public InmuebleDTO update(Long id, InmuebleDTO Inmueble){

        //busca el Inmueble por id en la bd
        Optional<Inmueble> InmuebleCurrentOptional = InmuebleRepository.findById(id);

        //valida si el Inmueble esta
        if(InmuebleCurrentOptional.isPresent()){

            //convierto EL DTO que traia de parametro a entidad
            Inmueble InmuebleCurrent = InmuebleConversion.convertirDTOAInmueble(Inmueble);
            InmuebleCurrent.setId_inmueble(id);
            //InmuebleCurrent.setCedula(Inmueble.getCedula());

            //Guardado en la BD
            InmuebleRepository.save(InmuebleCurrent);

            return InmuebleConversion.convertirInmuebleADTO(InmuebleCurrent);
        }
        return null;     
    }

    @Override 
    public void deleteById(Long id){
        InmuebleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InmuebleDTO> findAll(){
        List<Inmueble> Inmuebles = (List<Inmueble>) InmuebleRepository.findAll();
        return Inmuebles.stream()
                        .map(Inmueble -> InmuebleConversion.convertirInmuebleADTO(Inmueble))
                        .toList();
    }


    @Override
    public List<InmuebleDTO> ListadoEstancias(){
        List<Inmueble> Inmuebles = (List<Inmueble>) InmuebleRepository.ListadoEstancias();
        return Inmuebles.stream()
                        .map(voluntariito -> InmuebleConversion.convertirInmuebleADTO(voluntariito))
                        .toList();
    }

/* @Override
@Transactional(readOnly = true)
public List<InmuebleDTO> ListadoEstancias(Inmueble id_inmueble){
    List<Inmueble> Inmuebles = (List<Inmueble>) InmuebleRepository.ListadoEstancias(id_inmueble);
    return Inmuebles.stream().map(inm -> InmuebleConversion.convertirSocioADto(inm)).toList();
} */
}
