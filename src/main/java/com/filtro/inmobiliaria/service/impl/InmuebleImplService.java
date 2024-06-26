package com.filtro.inmobiliaria.service.impl;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.inmobiliaria.configuration.InmuebleConversion;
import com.filtro.inmobiliaria.repository.InmuebleRepository;
import com.filtro.inmobiliaria.repository.entities.Inmueble;
import com.filtro.inmobiliaria.repository.entitiesDTO.InmuebleDTO;
import com.filtro.inmobiliaria.service.InmuebleService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class InmuebleImplService implements InmuebleService {
        

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

    @Override
    @Transactional(readOnly = true)
    public InmuebleDTO findById(Long id){
        Optional<Inmueble> InmuebleCurrentOptional = InmuebleRepository.findById(id);

        return InmuebleConversion.convertirInmuebleADTO(InmuebleCurrentOptional.get());

    }


    @Override
    @Transactional(readOnly = true)
    public InmuebleDTO findByCodigo(Long codigo){
        Optional<Inmueble> inmuebleOptional = InmuebleRepository.findByCodigo(codigo);
        
        if (inmuebleOptional.isPresent()) {
            Inmueble inmueble = inmuebleOptional.get();
            return InmuebleConversion.convertirInmuebleADTO(inmueble);
        } else {
            throw new EntityNotFoundException("No se encontró un inmueble con el código " + codigo);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<InmuebleDTO> findAvailableForSaleOrRent(String type){
        List<String> types = Arrays.asList(type);
        List<Inmueble> inmuebles = InmuebleRepository.findByOfrecidoComoIn(types);
        
        return inmuebles.stream()
            .map(InmuebleConversion::convertirInmuebleADTO)
            .collect(Collectors.toList());
    }
}
