package com.filtro.inmobiliaria.repository.entitiesDTO;


import java.util.List;

import com.filtro.inmobiliaria.repository.entities.Estancia;
import com.filtro.inmobiliaria.repository.entities.Inmueble;
import jakarta.validation.constraints.NotEmpty;
//import com.filtro.inmobiliaria.repository.entities.Cliente;
import lombok.Data;



@Data
public class InmuebleDTO {

    @NotEmpty(message = "no puede estar vacio")
    private Long id_inmueble;

    @NotEmpty(message = "no puede estar vacio")
    private String codigo;

    @NotEmpty(message = "no puede estar vacio")
    private String nuevo;

    @NotEmpty(message = "no puede estar vacio")
    private String superficie;

    @NotEmpty(message = "no puede estar vacio")
    private String urbanizacion;

    @NotEmpty(message = "no puede estar vacio")
    private String direccion;

    @NotEmpty(message = "no puede estar vacio")
    private String caracteristicas;

    @NotEmpty(message = "no puede estar vacio")
    private String nom_propietario;

    @NotEmpty(message = "no puede estar vacio")
    private String tel_propietario;

    @NotEmpty(message = "no puede estar vacio")
    private String precio;

    @NotEmpty(message = "no puede estar vacio")
    private Inmueble.ofrecido_como ofrecido_como; 

}
