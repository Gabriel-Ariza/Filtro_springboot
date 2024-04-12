package com.filtro.inmobiliaria.repository.entitiesDTO;


import com.filtro.inmobiliaria.repository.entities.Cliente;


import jakarta.validation.constraints.NotEmpty;
//import com.filtro.inmobiliaria.repository.entities.Cliente;
import lombok.Data;



@Data
public class VisitaDTO {
    

    @NotEmpty(message = "no puede estar vacio")
    private Long id_estancia;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;


    @NotEmpty(message = "no puede estar vacio")
    private Long id_visita;


    @NotEmpty(message = "no puede estar vacio")
    private String fecha;

    @NotEmpty(message = "no puede estar vacio")
    private String comentario;


    @NotEmpty(message = "no puede estar vacio")
    private Cliente cliente;
}
