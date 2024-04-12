package com.filtro.inmobiliaria.repository.entitiesDTO;


import jakarta.validation.constraints.NotEmpty;
//import com.filtro.inmobiliaria.repository.entities.Cliente;
import lombok.Data;



@Data
public class OficinaDTO {

    private Long id_oficina;
    @NotEmpty(message = "no puede estar vacio")
    private String direccion;
    @NotEmpty(message = "no puede estar vacio")
    private String urbanizacion;

}
