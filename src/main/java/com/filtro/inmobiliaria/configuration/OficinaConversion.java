package com.filtro.inmobiliaria.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.filtro.inmobiliaria.repository.entities.Oficina;
import com.filtro.inmobiliaria.repository.entitiesDTO.OficinaDTO;


@Configuration
public class OficinaConversion {
        

    @Autowired
    private ModelMapper dbm;

    public Oficina convertirDTOAOficina(OficinaDTO OficinaDTO){
        return dbm.map(OficinaDTO,Oficina.class);
    }

    public OficinaDTO convertirOficinaADto(Oficina Oficina){
        OficinaDTO OficinaDTO = dbm.map(Oficina, OficinaDTO.class);

        OficinaDTO.setId_oficina(Oficina.getId_oficina());
        OficinaDTO.setDireccion(Oficina.getDireccion());
        OficinaDTO.setUrbanizacion(Oficina.getUrbanizacion());

        return OficinaDTO;
    }
}


