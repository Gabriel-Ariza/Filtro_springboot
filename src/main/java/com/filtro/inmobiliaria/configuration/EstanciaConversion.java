package com.filtro.inmobiliaria.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.filtro.inmobiliaria.repository.entities.Estancia;
import com.filtro.inmobiliaria.repository.entitiesDTO.EstanciaDTO;


@Configuration
public class EstanciaConversion {
    

    @Autowired
    private ModelMapper dbm;

    public Estancia convertirDTOAEstancia(EstanciaDTO EstanciaDTO){
        return dbm.map(EstanciaDTO,Estancia.class);
    }

    public EstanciaDTO convertirEstanciaADto(Estancia Estancia){
        EstanciaDTO EstanciaDTO = dbm.map(Estancia, EstanciaDTO.class);

        EstanciaDTO.setId_estancia(Estancia.getId_estancia());
        EstanciaDTO.setNombre(Estancia.getNombre());

        return EstanciaDTO;
    }
}

