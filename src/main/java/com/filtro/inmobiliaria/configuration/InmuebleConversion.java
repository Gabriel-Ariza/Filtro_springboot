package com.filtro.inmobiliaria.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.filtro.inmobiliaria.repository.entities.Inmueble;
import com.filtro.inmobiliaria.repository.entitiesDTO.InmuebleDTO;


@Configuration
public class InmuebleConversion {
        

    @Autowired
    private ModelMapper dbm;

    public Inmueble convertirDTOAInmueble(InmuebleDTO InmuebleDTO){
        return dbm.map(InmuebleDTO,Inmueble.class);
    } 

    public InmuebleDTO convertirInmuebleADTO(Inmueble Inmueble){
        InmuebleDTO InmuebleDTO = dbm.map(Inmueble, InmuebleDTO.class);

        InmuebleDTO.setId_inmueble(Inmueble.getId_inmueble());
        InmuebleDTO.setCodigo(Inmueble.getCodigo());
        InmuebleDTO.setNuevo(Inmueble.getNuevo());
        InmuebleDTO.setSuperficie(Inmueble.getSuperficie());
        InmuebleDTO.setUrbanizacion(Inmueble.getUrbanizacion());
        InmuebleDTO.setDireccion(Inmueble.getDireccion());
        InmuebleDTO.setCaracteristicas(Inmueble.getCaracteristicas());
        InmuebleDTO.setNom_propietario(Inmueble.getNom_propietario());
        InmuebleDTO.setTel_propietario(Inmueble.getTel_propietario());
        InmuebleDTO.setPrecio(Inmueble.getPrecio());


        return InmuebleDTO;
    }
}
